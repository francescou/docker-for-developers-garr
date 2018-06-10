docker build --tag t1 . && docker run --name troubleshooting-1  --mount type=tmpfs,tmpfs-size=1024,destination=/var/log/ --rm  t1
