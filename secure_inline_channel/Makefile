CC=gcc
CFLAGS=-std=c11 -Wall -Wextra -O2
LDLIBS=-lcrypto

all: secure_inline_device

secure_inline_device: device.c
	$(CC) $(CFLAGS) device.c -o secure_inline_device $(LDLIBS)

clean:
	rm -f secure_inline_device

.PHONY: all clean
