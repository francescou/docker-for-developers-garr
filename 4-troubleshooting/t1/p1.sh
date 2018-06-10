#! /bin/sh

# disk

dd if=/dev/zero of=/var/log/huge-log-file.log bs=1M count=1000
