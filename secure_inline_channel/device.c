#define _GNU_SOURCE

#include <arpa/inet.h>
#include <errno.h>
#include <linux/if_ether.h>
#include <linux/if_packet.h>
#include <net/if.h>
#include <netinet/ip.h>
#include <netinet/tcp.h>
#include <openssl/evp.h>
#include <openssl/rand.h>
#include <openssl/bn.h>
#include <poll.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ioctl.h>
#include <sys/socket.h>
#include <unistd.h>

#define MAX_FRAME 65536
#define DH_BYTES 256
#define GCM_NONCE_LEN 12
#define GCM_TAG_LEN 16
#define AES_KEY_LEN 32
#define HANDSHAKE_MAGIC 0x53494348u /* SICH */
#define HANDSHAKE_VERSION 1
#define DEFAULT_CTRL_PORT 45454

/* RFC 3526, 2048-bit MODP Group 14. */
static const char *DH_P_HEX =
    "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AACAA68FFFFFFFFFFFFFFFF";

struct config {
    int role;                    /* 1 = Device1, 2 = Device2 */
    char pc_if[IFNAMSIZ];
    char peer_if[IFNAMSIZ];
    char ctrl_ip[INET_ADDRSTRLEN];
    char peer_ip[INET_ADDRSTRLEN];
    uint16_t ctrl_port;
    uint16_t protected_port;
    unsigned char pc_next_hop[ETH_ALEN];
    unsigned char peer_next_hop[ETH_ALEN];
};

struct session {
    unsigned char key[AES_KEY_LEN];
    unsigned char session_salt[32];
    int ready;
};

struct handshake_msg {
    uint32_t magic;
    uint8_t version;
    uint8_t role;
    uint16_t reserved;
    uint32_t pub_len;
    unsigned char pub[DH_BYTES];
    unsigned char salt[32];
};

static void die(const char *msg) {
    perror(msg);
    exit(EXIT_FAILURE);
}

static void usage(const char *p) {
    fprintf(stderr,
        "Usage:\n"
        "  %s --role 1|2 --pc-if IFACE --peer-if IFACE --ctrl-ip IP --peer-ip IP \\\n"
        "     --pc-mac MAC --peer-mac MAC [--ctrl-port PORT] [--port PORT]\n\n"
        "Example Device1:\n"
        "  sudo %s --role 1 --pc-if eth1 --peer-if eth2 --ctrl-ip 10.10.0.1 \\\n"
        "     --peer-ip 10.10.0.2 --pc-mac aa:bb:cc:dd:ee:01 --peer-mac aa:bb:cc:dd:ee:02 --port 8080\n",
        p, p);
    exit(EXIT_FAILURE);
}

static int parse_mac(const char *s, unsigned char mac[ETH_ALEN]) {
    unsigned int b[6];
    if (sscanf(s, "%x:%x:%x:%x:%x:%x", &b[0], &b[1], &b[2], &b[3], &b[4], &b[5]) != 6)
        return 0;
    for (int i = 0; i < 6; ++i)
        if (b[i] > 255) return 0;
    for (int i = 0; i < 6; ++i) mac[i] = (unsigned char)b[i];
    return 1;
}

static uint16_t checksum16(const void *data, size_t len) {
    const uint16_t *p = (const uint16_t *)data;
    uint32_t sum = 0;
    while (len > 1) {
        sum += ntohs(*p++);
        len -= 2;
    }
    if (len) sum += *((const uint8_t *)p) << 8;
    while (sum >> 16) sum = (sum & 0xffff) + (sum >> 16);
    return htons((uint16_t)(~sum));
}

static uint16_t ip_checksum(struct iphdr *ip) {
    ip->check = 0;
    return checksum16(ip, ip->ihl * 4);
}

static uint16_t tcp_checksum(struct iphdr *ip, struct tcphdr *tcp, size_t tcp_len) {
    uint32_t sum = 0;
    uint32_t src = ntohl(ip->saddr);
    uint32_t dst = ntohl(ip->daddr);

    sum += (src >> 16) & 0xffff;
    sum += src & 0xffff;
    sum += (dst >> 16) & 0xffff;
    sum += dst & 0xffff;
    sum += IPPROTO_TCP;
    sum += (uint32_t)tcp_len;

    tcp->check = 0;
    const uint16_t *p = (const uint16_t *)tcp;
    size_t len = tcp_len;
    while (len > 1) {
        sum += ntohs(*p++);
        len -= 2;
    }
    if (len) sum += *((const uint8_t *)p) << 8;
    while (sum >> 16) sum = (sum & 0xffff) + (sum >> 16);
    return htons((uint16_t)(~sum));
}

static int sha256_parts(const unsigned char **parts, const size_t *lens, size_t n,
                        unsigned char out[32]) {
    EVP_MD_CTX *ctx = EVP_MD_CTX_new();
    unsigned int out_len = 0;
    if (!ctx) return 0;
    if (EVP_DigestInit_ex(ctx, EVP_sha256(), NULL) != 1) goto fail;
    for (size_t i = 0; i < n; ++i)
        if (EVP_DigestUpdate(ctx, parts[i], lens[i]) != 1) goto fail;
    if (EVP_DigestFinal_ex(ctx, out, &out_len) != 1 || out_len != 32) goto fail;
    EVP_MD_CTX_free(ctx);
    return 1;
fail:
    EVP_MD_CTX_free(ctx);
    return 0;
}

static int derive_session_key(const BIGNUM *shared, const unsigned char salt1[32],
                              const unsigned char salt2[32], unsigned char key[32]) {
    unsigned char shared_buf[DH_BYTES];
    if (BN_bn2binpad(shared, shared_buf, sizeof(shared_buf)) != DH_BYTES)
        return 0;
    static const unsigned char label[] = "SECURE-INLINE-AES-GCM-v1";
    const unsigned char *parts[] = { label, shared_buf, salt1, salt2 };
    const size_t lens[] = { sizeof(label) - 1, sizeof(shared_buf), 32, 32 };
    return sha256_parts(parts, lens, 4, key);
}

static int make_dh_pair(BIGNUM **p, BIGNUM **g, BIGNUM **priv, BIGNUM **pub) {
    BN_CTX *ctx = BN_CTX_new();
    if (!ctx) return 0;
    *p = *g = *priv = *pub = NULL;
    if (!BN_hex2bn(p, DH_P_HEX)) goto fail;
    *g = BN_new();
    *priv = BN_new();
    *pub = BN_new();
    if (!*g || !*priv || !*pub) goto fail;
    if (!BN_set_word(*g, 2)) goto fail;
    if (!BN_rand_range(*priv, *p)) goto fail;
    if (BN_is_zero(*priv) || BN_is_one(*priv)) goto fail;
    if (!BN_mod_exp(*pub, *g, *priv, *p, ctx)) goto fail;
    BN_CTX_free(ctx);
    return 1;
fail:
    BN_free(*p); BN_free(*g); BN_free(*priv); BN_free(*pub);
    *p = *g = *priv = *pub = NULL;
    BN_CTX_free(ctx);
    return 0;
}

static int compute_shared(const BIGNUM *p, const BIGNUM *priv,
                          const unsigned char peer_bytes[DH_BYTES], BIGNUM **shared_out) {
    BN_CTX *ctx = BN_CTX_new();
    BIGNUM *peer = BN_new();
    BIGNUM *shared = BN_new();
    if (!ctx || !peer || !shared) goto fail;
    if (!BN_bin2bn(peer_bytes, DH_BYTES, peer)) goto fail;
    if (BN_cmp(peer, BN_value_one()) <= 0 || BN_cmp(peer, p) >= 0) goto fail;
    if (!BN_mod_exp(shared, peer, priv, p, ctx)) goto fail;
    *shared_out = shared;
    BN_free(peer);
    BN_CTX_free(ctx);
    return 1;
fail:
    BN_free(peer); BN_free(shared); BN_CTX_free(ctx);
    return 0;
}

static int do_handshake(const struct config *cfg, struct session *s) {
    BIGNUM *p = NULL, *g = NULL, *priv = NULL, *pub = NULL, *shared = NULL;
    if (!make_dh_pair(&p, &g, &priv, &pub)) {
        fprintf(stderr, "DH key generation failed\n");
        return 0;
    }

    struct handshake_msg msg, peer_msg;
    memset(&msg, 0, sizeof(msg));
    memset(&peer_msg, 0, sizeof(peer_msg));
    msg.magic = htonl(HANDSHAKE_MAGIC);
    msg.version = HANDSHAKE_VERSION;
    msg.role = (uint8_t)cfg->role;
    msg.pub_len = htonl(DH_BYTES);
    if (BN_bn2binpad(pub, msg.pub, DH_BYTES) != DH_BYTES || RAND_bytes(msg.salt, 32) != 1) {
        fprintf(stderr, "Failed to create DH handshake material\n");
        goto fail;
    }

    int fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (fd < 0) die("socket handshake");

    struct sockaddr_in local = {0}, peer = {0};
    local.sin_family = AF_INET;
    local.sin_port = htons(cfg->ctrl_port);
    if (inet_pton(AF_INET, cfg->ctrl_ip, &local.sin_addr) != 1) {
        fprintf(stderr, "Invalid --ctrl-ip\n"); close(fd); goto fail;
    }

    if (cfg->role == 2) {
        if (bind(fd, (struct sockaddr *)&local, sizeof(local)) < 0) die("bind handshake");
        fprintf(stderr, "Device2: waiting for Device1 DH handshake on %s:%u...\n",
                cfg->ctrl_ip, cfg->ctrl_port);
        socklen_t plen = sizeof(peer);
        ssize_t n = recvfrom(fd, &peer_msg, sizeof(peer_msg), 0,
                             (struct sockaddr *)&peer, &plen);
        if (n != (ssize_t)sizeof(peer_msg)) {
            fprintf(stderr, "Invalid handshake size\n"); close(fd); goto fail;
        }
        if (ntohl(peer_msg.magic) != HANDSHAKE_MAGIC || peer_msg.version != HANDSHAKE_VERSION ||
            peer_msg.role != 1 || ntohl(peer_msg.pub_len) != DH_BYTES) {
            fprintf(stderr, "Invalid Device1 handshake\n"); close(fd); goto fail;
        }
        /* Return Device2's public value and salt. */
        if (sendto(fd, &msg, sizeof(msg), 0, (struct sockaddr *)&peer, plen) != (ssize_t)sizeof(msg)) {
            perror("send handshake reply"); close(fd); goto fail;
        }
    } else {
        peer.sin_family = AF_INET;
        peer.sin_port = htons(cfg->ctrl_port);
        if (inet_pton(AF_INET, cfg->peer_ip, &peer.sin_addr) != 1) {
            fprintf(stderr, "Invalid --peer-ip\n"); close(fd); goto fail;
        }
        if (sendto(fd, &msg, sizeof(msg), 0, (struct sockaddr *)&peer, sizeof(peer)) != (ssize_t)sizeof(msg)) {
            perror("send handshake"); close(fd); goto fail;
        }
        struct timeval tv = {5, 0};
        setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &tv, sizeof(tv));
        ssize_t n = recvfrom(fd, &peer_msg, sizeof(peer_msg), 0, NULL, NULL);
        if (n != (ssize_t)sizeof(peer_msg)) {
            perror("receive handshake reply"); close(fd); goto fail;
        }
        if (ntohl(peer_msg.magic) != HANDSHAKE_MAGIC || peer_msg.version != HANDSHAKE_VERSION ||
            peer_msg.role != 2 || ntohl(peer_msg.pub_len) != DH_BYTES) {
            fprintf(stderr, "Invalid Device2 handshake\n"); close(fd); goto fail;
        }
    }

    if (cfg->role == 1) {
        if (!compute_shared(p, priv, peer_msg.pub, &shared)) goto fail_socket;
        if (!derive_session_key(shared, msg.salt, peer_msg.salt, s->key)) goto fail_socket;
        memcpy(s->session_salt, msg.salt, 32);
    } else {
        if (!compute_shared(p, priv, peer_msg.pub, &shared)) goto fail_socket;
        if (!derive_session_key(shared, peer_msg.salt, msg.salt, s->key)) goto fail_socket;
        memcpy(s->session_salt, peer_msg.salt, 32);
    }
    s->ready = 1;
    fprintf(stderr, "Device%d: DH handshake complete; AES-256-GCM session established.\n", cfg->role);
    close(fd);
    BN_free(shared); BN_free(p); BN_free(g); BN_free(priv); BN_free(pub);
    return 1;

fail_socket:
    close(fd);
fail:
    BN_free(shared); BN_free(p); BN_free(g); BN_free(priv); BN_free(pub);
    return 0;
}

static void make_nonce(const struct session *s, int direction, const struct iphdr *ip,
                       const struct tcphdr *tcp, unsigned char nonce[GCM_NONCE_LEN]) {
    /*
     * No nonce is added to the packet because the assignment forbids a custom
     * header. The nonce is deterministically derived from authenticated TCP/IP
     * fields and the session key. The same TCP segment retransmitted unchanged
     * derives the same nonce, so it is the same logical encryption operation.
     */
    unsigned char dir = (unsigned char)direction;
    uint32_t seq = tcp->seq;
    uint32_t ack = tcp->ack_seq;
    uint16_t id = ip->id;
    uint16_t sport = tcp->source;
    uint16_t dport = tcp->dest;
    const unsigned char *parts[] = {
        s->key, &dir,
        (const unsigned char *)&ip->saddr, (const unsigned char *)&ip->daddr,
        (const unsigned char *)&sport, (const unsigned char *)&dport,
        (const unsigned char *)&seq, (const unsigned char *)&ack,
        (const unsigned char *)&id
    };
    const size_t lens[] = {32, 1, 4, 4, 2, 2, 4, 4, 2};
    unsigned char digest[32];
    if (!sha256_parts(parts, lens, sizeof(parts)/sizeof(parts[0]), digest))
        memset(digest, 0, sizeof(digest));
    memcpy(nonce, digest, GCM_NONCE_LEN);
}

static int gcm_encrypt(const unsigned char key[32], const unsigned char nonce[12],
                       const unsigned char *aad, int aad_len,
                       const unsigned char *plaintext, int plaintext_len,
                       unsigned char *ciphertext, unsigned char tag[16]) {
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    int out_len = 0, final_len = 0;
    if (!ctx) return 0;
    if (EVP_EncryptInit_ex(ctx, EVP_aes_256_gcm(), NULL, NULL, NULL) != 1) goto fail;
    if (EVP_CIPHER_CTX_ctrl(ctx, EVP_CTRL_GCM_SET_IVLEN, GCM_NONCE_LEN, NULL) != 1) goto fail;
    if (EVP_EncryptInit_ex(ctx, NULL, NULL, key, nonce) != 1) goto fail;
    if (aad_len > 0 && EVP_EncryptUpdate(ctx, NULL, &out_len, aad, aad_len) != 1) goto fail;
    if (plaintext_len > 0 && EVP_EncryptUpdate(ctx, ciphertext, &out_len, plaintext, plaintext_len) != 1) goto fail;
    if (EVP_EncryptFinal_ex(ctx, ciphertext + out_len, &final_len) != 1) goto fail;
    if (EVP_CIPHER_CTX_ctrl(ctx, EVP_CTRL_GCM_GET_TAG, GCM_TAG_LEN, tag) != 1) goto fail;
    EVP_CIPHER_CTX_free(ctx);
    return out_len + final_len == plaintext_len;
fail:
    EVP_CIPHER_CTX_free(ctx);
    return 0;
}

static int gcm_decrypt(const unsigned char key[32], const unsigned char nonce[12],
                       const unsigned char *aad, int aad_len,
                       const unsigned char *ciphertext, int ciphertext_len,
                       const unsigned char tag[16], unsigned char *plaintext) {
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    int out_len = 0, final_len = 0;
    if (!ctx) return 0;
    if (EVP_DecryptInit_ex(ctx, EVP_aes_256_gcm(), NULL, NULL, NULL) != 1) goto fail;
    if (EVP_CIPHER_CTX_ctrl(ctx, EVP_CTRL_GCM_SET_IVLEN, GCM_NONCE_LEN, NULL) != 1) goto fail;
    if (EVP_DecryptInit_ex(ctx, NULL, NULL, key, nonce) != 1) goto fail;
    if (aad_len > 0 && EVP_DecryptUpdate(ctx, NULL, &out_len, aad, aad_len) != 1) goto fail;
    if (ciphertext_len > 0 && EVP_DecryptUpdate(ctx, plaintext, &out_len, ciphertext, ciphertext_len) != 1) goto fail;
    if (EVP_CIPHER_CTX_ctrl(ctx, EVP_CTRL_GCM_SET_TAG, GCM_TAG_LEN, (void *)tag) != 1) goto fail;
    if (EVP_DecryptFinal_ex(ctx, plaintext + out_len, &final_len) != 1) {
        EVP_CIPHER_CTX_free(ctx);
        return -1; /* authentication failure */
    }
    EVP_CIPHER_CTX_free(ctx);
    return out_len + final_len == ciphertext_len;
fail:
    EVP_CIPHER_CTX_free(ctx);
    return 0;
}

static int bind_packet_socket(const char *ifname) {
    int fd = socket(AF_PACKET, SOCK_RAW, htons(ETH_P_ALL));
    if (fd < 0) die("AF_PACKET socket");
    struct sockaddr_ll addr = {0};
    addr.sll_family = AF_PACKET;
    addr.sll_protocol = htons(ETH_P_ALL);
    addr.sll_ifindex = if_nametoindex(ifname);
    if (!addr.sll_ifindex) die("if_nametoindex");
    if (bind(fd, (struct sockaddr *)&addr, sizeof(addr)) < 0) die("bind AF_PACKET");
    return fd;
}

static int get_if_mac(const char *ifname, unsigned char mac[ETH_ALEN]) {
    int fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (fd < 0) return 0;
    struct ifreq ifr;
    memset(&ifr, 0, sizeof(ifr));
    strncpy(ifr.ifr_name, ifname, IFNAMSIZ - 1);
    int ok = ioctl(fd, SIOCGIFHWADDR, &ifr) == 0;
    if (ok) memcpy(mac, ifr.ifr_hwaddr.sa_data, ETH_ALEN);
    close(fd);
    return ok;
}

static int is_selected_tcp(const struct config *cfg, const struct iphdr *ip, const struct tcphdr *tcp) {
    if (ip->version != 4 || ip->protocol != IPPROTO_TCP) return 0;
    if (ntohs(tcp->source) != cfg->protected_port && ntohs(tcp->dest) != cfg->protected_port)
        return 0;
    return 1;
}

static int transform_packet(const struct config *cfg, const struct session *s,
                            unsigned char *frame, ssize_t *frame_len, int encrypt,
                            int direction) {
    if (*frame_len < (ssize_t)(sizeof(struct ethhdr) + sizeof(struct iphdr))) return 0;
    struct ethhdr *eth = (struct ethhdr *)frame;
    if (ntohs(eth->h_proto) != ETH_P_IP) return 0;

    struct iphdr *ip = (struct iphdr *)(frame + sizeof(struct ethhdr));
    size_t ip_hlen = ip->ihl * 4;
    if (ip_hlen < 20 || *frame_len < (ssize_t)(sizeof(struct ethhdr) + ip_hlen)) return 0;
    if (ip->version != 4 || ip->protocol != IPPROTO_TCP) return 0;
    if (ntohs(ip->frag_off) & (IP_MF | IP_OFFMASK)) return 0; /* no fragmentation */
    if (ntohs(ip->tot_len) > *frame_len - (ssize_t)sizeof(struct ethhdr)) return 0;

    struct tcphdr *tcp = (struct tcphdr *)(frame + sizeof(struct ethhdr) + ip_hlen);
    size_t tcp_hlen = tcp->doff * 4;
    if (tcp_hlen < 20) return 0;
    size_t ip_total = ntohs(ip->tot_len);
    if (ip_total < ip_hlen + tcp_hlen) return 0;
    size_t payload_len = ip_total - ip_hlen - tcp_hlen;
    unsigned char *payload = frame + sizeof(struct ethhdr) + ip_hlen + tcp_hlen;

    if (!is_selected_tcp(cfg, ip, tcp)) return 0;

    /* Only packets carrying a TCP payload are encrypted. Pure ACKs are forwarded. */
    if (payload_len == 0) {
        ip->check = ip_checksum(ip);
        tcp->check = tcp_checksum(ip, tcp, tcp_hlen);
        return 1;
    }

    unsigned char nonce[GCM_NONCE_LEN];
    make_nonce(s, direction, ip, tcp, nonce);

    if (encrypt) {
        if (payload_len + GCM_TAG_LEN > MAX_FRAME - sizeof(struct ethhdr) - ip_hlen - tcp_hlen)
            return 0;
        unsigned char *tmp = malloc(payload_len + GCM_TAG_LEN);
        if (!tmp) return 0;

        /* Authenticate the original IP/TCP headers, excluding checksums. */
        unsigned char aad[60 + 60];
        if (ip_hlen + tcp_hlen > sizeof(aad)) { free(tmp); return 0; }
        memcpy(aad, ip, ip_hlen + tcp_hlen);
        struct iphdr *aad_ip = (struct iphdr *)aad;
        struct tcphdr *aad_tcp = (struct tcphdr *)(aad + ip_hlen);
        aad_ip->check = 0;
        aad_tcp->check = 0;

        unsigned char tag[GCM_TAG_LEN];
        if (!gcm_encrypt(s->key, nonce, aad, ip_hlen + tcp_hlen,
                         payload, (int)payload_len, tmp, tag)) {
            free(tmp); return 0;
        }
        memcpy(payload, tmp, payload_len);
        memcpy(payload + payload_len, tag, GCM_TAG_LEN);
        free(tmp);
        ip->tot_len = htons((uint16_t)(ip_total + GCM_TAG_LEN));
        ip->check = ip_checksum(ip);
        tcp->check = tcp_checksum(ip, tcp, tcp_hlen + payload_len + GCM_TAG_LEN);
        *frame_len += GCM_TAG_LEN;
        return 1;
    } else {
        if (payload_len < GCM_TAG_LEN) return 0;
        size_t ciphertext_len = payload_len - GCM_TAG_LEN;
        unsigned char *tmp = malloc(ciphertext_len);
        if (!tmp) return 0;

        unsigned char aad[120];
        if (ip_hlen + tcp_hlen > sizeof(aad)) { free(tmp); return 0; }
        memcpy(aad, ip, ip_hlen + tcp_hlen);
        struct iphdr *aad_ip = (struct iphdr *)aad;
        struct tcphdr *aad_tcp = (struct tcphdr *)(aad + ip_hlen);
        /* Restore the original total length before authenticating AAD. */
        aad_ip->tot_len = htons((uint16_t)(ip_total - GCM_TAG_LEN));
        aad_ip->check = 0;
        aad_tcp->check = 0;

        int rc = gcm_decrypt(s->key, nonce, aad, ip_hlen + tcp_hlen,
                             payload, (int)ciphertext_len,
                             payload + ciphertext_len, tmp);
        if (rc != 1) {
            if (rc == -1) fprintf(stderr, "Device%d: dropped packet: GCM authentication failed\n", cfg->role);
            free(tmp);
            return 0;
        }
        memcpy(payload, tmp, ciphertext_len);
        free(tmp);
        ip->tot_len = htons((uint16_t)(ip_total - GCM_TAG_LEN));
        ip->check = ip_checksum(ip);
        tcp->check = tcp_checksum(ip, tcp, tcp_hlen + ciphertext_len);
        *frame_len -= GCM_TAG_LEN;
        return 1;
    }
}

static int send_frame(int fd, int ifindex, const unsigned char *frame, size_t len) {
    struct sockaddr_ll out = {0};
    out.sll_family = AF_PACKET;
    out.sll_ifindex = ifindex;
    out.sll_halen = ETH_ALEN;
    memcpy(out.sll_addr, frame, ETH_ALEN);
    ssize_t n = sendto(fd, frame, len, 0, (struct sockaddr *)&out, sizeof(out));
    return n == (ssize_t)len;
}

static int forward_one(const struct config *cfg, const struct session *s,
                       int in_fd, int out_fd, int in_is_pc, int out_ifindex,
                       const unsigned char own_mac[ETH_ALEN]) {
    unsigned char frame[MAX_FRAME];
    struct sockaddr_ll from = {0};
    socklen_t from_len = sizeof(from);
    ssize_t n = recvfrom(in_fd, frame, sizeof(frame), 0,
                         (struct sockaddr *)&from, &from_len);
    if (n <= 0) return 0;
    /* Ignore frames generated by this device itself. */
    if (from.sll_pkttype == PACKET_OUTGOING) return 1;
    if (n < (ssize_t)sizeof(struct ethhdr)) return 1;

    struct ethhdr *eth = (struct ethhdr *)frame;
    if (ntohs(eth->h_proto) != ETH_P_IP) return 1;

    struct iphdr *ip = (struct iphdr *)(frame + sizeof(struct ethhdr));
    if (ip->version != 4 || ip->protocol != IPPROTO_TCP) return 1;
    size_t ip_hlen = ip->ihl * 4;
    if (ip_hlen < 20 || n < (ssize_t)(sizeof(struct ethhdr) + ip_hlen)) return 1;
    struct tcphdr *tcp = (struct tcphdr *)(frame + sizeof(struct ethhdr) + ip_hlen);
    if ((unsigned char *)tcp + sizeof(struct tcphdr) > frame + n) return 1;
    if (!is_selected_tcp(cfg, ip, tcp)) {
        /* This prototype only forwards the selected traffic. */
        return 1;
    }

    int encrypt = in_is_pc ? (cfg->role == 1 || cfg->role == 2) : 0;
    /* Device1: PC->peer encrypt, peer->PC decrypt.
       Device2: peer->PC decrypt, PC->peer encrypt. */
    if (cfg->role == 1) encrypt = in_is_pc ? 1 : 0;
    if (cfg->role == 2) encrypt = in_is_pc ? 0 : 1;

    int direction = (cfg->role == 1)
        ? (in_is_pc ? 1 : 2)
        : (in_is_pc ? 2 : 1);

    ssize_t out_len = n;
    if (!transform_packet(cfg, s, frame, &out_len, encrypt, direction)) {
        /* A failed transform means do not forward the protected packet. */
        return 1;
    }

    memcpy(eth->h_source, own_mac, ETH_ALEN);
    if (in_is_pc)
        memcpy(eth->h_dest, cfg->peer_next_hop, ETH_ALEN);
    else
        memcpy(eth->h_dest, cfg->pc_next_hop, ETH_ALEN);

    if (!send_frame(out_fd, out_ifindex, frame, (size_t)out_len))
        perror("send_frame");
    return 1;
}

static void parse_args(int argc, char **argv, struct config *cfg) {
    memset(cfg, 0, sizeof(*cfg));
    cfg->ctrl_port = DEFAULT_CTRL_PORT;
    cfg->protected_port = 8080;

    for (int i = 1; i < argc; ++i) {
        if (!strcmp(argv[i], "--role") && i + 1 < argc) cfg->role = atoi(argv[++i]);
        else if (!strcmp(argv[i], "--pc-if") && i + 1 < argc) strncpy(cfg->pc_if, argv[++i], IFNAMSIZ - 1);
        else if (!strcmp(argv[i], "--peer-if") && i + 1 < argc) strncpy(cfg->peer_if, argv[++i], IFNAMSIZ - 1);
        else if (!strcmp(argv[i], "--ctrl-ip") && i + 1 < argc) strncpy(cfg->ctrl_ip, argv[++i], sizeof(cfg->ctrl_ip)-1);
        else if (!strcmp(argv[i], "--peer-ip") && i + 1 < argc) strncpy(cfg->peer_ip, argv[++i], sizeof(cfg->peer_ip)-1);
        else if (!strcmp(argv[i], "--pc-mac") && i + 1 < argc) { if (!parse_mac(argv[++i], cfg->pc_next_hop)) usage(argv[0]); }
        else if (!strcmp(argv[i], "--peer-mac") && i + 1 < argc) { if (!parse_mac(argv[++i], cfg->peer_next_hop)) usage(argv[0]); }
        else if (!strcmp(argv[i], "--ctrl-port") && i + 1 < argc) cfg->ctrl_port = (uint16_t)atoi(argv[++i]);
        else if (!strcmp(argv[i], "--port") && i + 1 < argc) cfg->protected_port = (uint16_t)atoi(argv[++i]);
        else usage(argv[0]);
    }

    if ((cfg->role != 1 && cfg->role != 2) || !cfg->pc_if[0] || !cfg->peer_if[0] ||
        !cfg->ctrl_ip[0] || !cfg->peer_ip[0]) usage(argv[0]);
}

int main(int argc, char **argv) {
    struct config cfg;
    struct session session;
    parse_args(argc, argv, &cfg);
    memset(&session, 0, sizeof(session));

    if (!do_handshake(&cfg, &session)) {
        fprintf(stderr, "Secure session establishment failed. Exiting.\n");
        return EXIT_FAILURE;
    }

    int pc_fd = bind_packet_socket(cfg.pc_if);
    int peer_fd = bind_packet_socket(cfg.peer_if);
    int pc_ifindex = (int)if_nametoindex(cfg.pc_if);
    int peer_ifindex = (int)if_nametoindex(cfg.peer_if);
    unsigned char pc_mac[ETH_ALEN], peer_mac[ETH_ALEN];
    if (!get_if_mac(cfg.pc_if, pc_mac) || !get_if_mac(cfg.peer_if, peer_mac))
        die("get interface MAC");

    fprintf(stderr, "Device%d is forwarding selected TCP port %u.\n", cfg.role, cfg.protected_port);
    fprintf(stderr, "PC interface: %s, peer interface: %s\n", cfg.pc_if, cfg.peer_if);

    struct pollfd fds[2] = {
        { .fd = pc_fd, .events = POLLIN },
        { .fd = peer_fd, .events = POLLIN }
    };

    while (1) {
        int rc = poll(fds, 2, -1);
        if (rc < 0) {
            if (errno == EINTR) continue;
            die("poll");
        }
        if (fds[0].revents & POLLIN)
            forward_one(&cfg, &session, pc_fd, peer_fd, 1, peer_ifindex, peer_mac);
        if (fds[1].revents & POLLIN)
            forward_one(&cfg, &session, peer_fd, pc_fd, 0, pc_ifindex, pc_mac);
    }

    close(pc_fd);
    close(peer_fd);
    return 0;
}
