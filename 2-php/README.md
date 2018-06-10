```
docker run --rm -e MYSQL_ROOT_PASSWORD=pww --volume $(pwd)/db/:/var/lib/mysql/ --name database  --publish 3306:3306  mysql:5.6

docker build --tag garr-workshop/humidity:1.0 .

docker run --rm --link database:database -e MYSQL_HOST=database -e MYSQL_PASSWORD=pww --name php-webapp --publish 8080:80  garr-workshop/humidity:1.0

docker exec -ti $(docker ps |  grep -w mysql | cut -d ' ' -f1) mysql -ppww
```
