```
docker run --rm -e MYSQL_ROOT_PASSWORD=pww --name database  -p 3306:3306  mysql:5.6

docker build -t garr-workshop/humidity:1.0 .

docker run --rm --link database:database -e MYSQL_HOST=database -e MYSQL_PASSWORD=pww --name php-webapp -p 8080:80  garr-workshop/humidity:1.0

docker exec -ti $(docker ps |  grep -w mysql | cut -d ' ' -f1) mysql -ppww
```

TODO: montare volume mysql esterno