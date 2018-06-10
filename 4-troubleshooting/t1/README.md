docker build -t t1 . && docker run  --mount type=tmpfs,tmpfs-size=1024,destination=/var/log/ --rm  t1
