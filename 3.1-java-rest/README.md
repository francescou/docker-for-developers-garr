```bash
docker run --rm -p 3306:3306  -e MYSQL_ROOT_PASSWORD=springrootpw \
  -e MYSQL_DATABASE=status  -e MYSQL_USER=spring -e MYSQL_PASSWORD=springpw \
  --name mysql   mysql:5.6
```

```bash

docker build --tag garr-workshop/java:1.0 .

docker run --link mysql:mysql-db --name webapp --publish 8080:8080 --rm garr-workshop/java:1.0

curl http://localhost:8080
```
