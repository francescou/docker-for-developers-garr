```
docker build --tag garr-workshop/ui:1.0 .

docker run --rm --name webserver --publish 8080:80   garr-workshop/ui:1.0

curl localhost:8080

docker logs webserver

docker exec webserver ls -l /usr/share/nginx/html

docker inspect webserver | grep -w IPAddress # don't do this!

curl http://172.17.0.2

docker run --rm --volume $(pwd)/:/usr/share/nginx/html/  --name webserver --publish 8080:80   garr-workshop/ui:1.0
```


## browsersync

```bash
docker build --file Dockerfile-browsersync --tag garr-workshop/ui:browsersync .

docker run --volume $(pwd):/app/:ro --publish 3000:3000 --rm garr-workshop/ui:browsersync

sed -i s/Temperature/Temperatura/g index.html
```