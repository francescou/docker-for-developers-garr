#! /bin/sh

# I/O da lanciare in parallelo

for i in `seq 1 100`;
do
dd if=/dev/zero of=/tmp/huge-file bs=1M count=1000
rm /tmp/huge-file
done
