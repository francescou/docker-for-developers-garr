```
docker build -t garr-workshop/ui:1.0 .

docker run --rm --name webserver -p 8080:80   garr-workshop/ui:1.0

curl localhost:8080

docker logs webserver

docker exec webserver ls -l /usr/share/nginx/html

docker inspect webserver | grep -w IPAddress # don't do this!

curl http://172.17.0.2

docker run --rm -v $(pwd)/:/usr/share/nginx/html/  --name webserver -p 8080:80   garr-workshop/ui:1.0
```

TODO: browsersync