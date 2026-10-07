# Secure Inline TCP Communication Channel in C

Linux prototype for:

```text
PC1 -> Device1 -> Device2 -> PC2
```

The prototype uses:

- Linux `AF_PACKET` raw sockets for inline Ethernet forwarding.
- Diffie-Hellman MODP Group 14 (2048-bit) between Device1 and Device2.
- SHA-256 KDF to derive a 256-bit AES session key.
- AES-256-GCM for TCP payload protection.
- The original IPv4 and TCP headers are retained.
- The 16-byte GCM authentication tag is appended directly after the encrypted TCP payload.
- No UDP encapsulation or custom data-plane header is used.
- At Device2, the tag is verified and the payload is decrypted before forwarding to PC2.
- IPv4 and TCP checksums are recalculated after every transformation.
- TCP sequence and acknowledgement numbers are not changed, so the endpoints continue to see their original TCP stream.

## Important prototype design choice: nonce

The assignment requires a unique AES-GCM nonce but does not allow a custom packet header in which to carry the nonce. Therefore the prototype derives a 96-bit nonce deterministically from the session key, direction, and authenticated TCP/IP fields (5-tuple, TCP sequence/acknowledgement numbers and IPv4 identification field).

A retransmitted copy of the exact same TCP segment derives the same nonce and represents the same logical encryption operation. Different TCP segments have different TCP sequence numbers in a normal TCP stream.

For a production implementation, an explicit nonce/counter transport mechanism or an authenticated tunnel format would normally be preferable. This project deliberately follows the assignment's no-custom-header constraint.

## Build

Ubuntu/Debian:

```bash
sudo apt update
sudo apt install build-essential libssl-dev
make
```

Run with root privileges because `AF_PACKET` raw sockets are used.

## Network topology

Example:

```text
PC1 ---- eth1  Device1  eth2 ---- eth2  Device2  eth1 ---- PC2
             10.10.0.1                 10.10.0.2
```

Use the real interface names and MAC addresses in your lab.

The `--pc-mac` and `--peer-mac` values are the next-hop Ethernet MAC addresses for the corresponding outgoing interface. On a simple point-to-point lab this is normally the MAC address of the machine directly connected to that interface.

## Device1

```bash
sudo ./secure_inline_device \
  --role 1 \
  --pc-if eth1 \
  --peer-if eth2 \
  --ctrl-ip 10.10.0.1 \
  --peer-ip 10.10.0.2 \
  --pc-mac AA:AA:AA:AA:AA:01 \
  --peer-mac AA:AA:AA:AA:AA:02 \
  --port 8080
```

## Device2

```bash
sudo ./secure_inline_device \
  --role 2 \
  --pc-if eth1 \
  --peer-if eth2 \
  --ctrl-ip 10.10.0.2 \
  --peer-ip 10.10.0.1 \
  --pc-mac BB:BB:BB:BB:BB:02 \
  --peer-mac BB:BB:BB:BB:BB:01 \
  --port 8080
```

Device2 waits for the UDP control handshake on port `45454` by default. This UDP socket is only used for session establishment; protected TCP data is never UDP-encapsulated.

## Linux forwarding setup

Because the program itself forwards selected frames at Layer 2, it does not depend on Linux IP forwarding for the selected traffic. In a lab, you should still configure the PCs' routes so the selected TCP path actually crosses the devices.

For example, on a PC that should use Device1 as a router, configure an appropriate route using `ip route` for the remote test subnet.

## Test

On PC2, start a TCP service:

```bash
nc -lv 8080
```

From PC1:

```bash
echo "hello from PC1" | nc PC2_IP 8080
```

The expected path is:

```text
PC1 plaintext TCP payload
        |
        v
Device1: DH session already established -> AES-GCM encrypt payload + append 16-byte tag
        |
        v
Device2: verify GCM tag -> decrypt payload -> restore original length/checksums
        |
        v
PC2 receives original TCP payload
```

## Security notes

This is an educational prototype, not a production VPN or secure tunnel. The DH exchange is not authenticated, so it is vulnerable to an active man-in-the-middle attack. A production design should authenticate the devices, use a carefully designed nonce/counter mechanism, handle fragmentation and TCP retransmission state explicitly, and use a kernel networking framework such as nftables/NFQUEUE, XDP, or a dedicated tunnel implementation.
