```
docker run \
  --env MYSQL_ROOT_PASSWORD=pippo \
  --volume $(pwd)/db/:/var/lib/mysql/ \
  --name wp-mysql \
  mysql:5.6
```


```
docker run --name some-wordpress \
  --link wp-mysql:mysql \
  --env WORDPRESS_DB_HOST=mysql \
  --env WORDPRESS_DB_PASSWORD=pippo \
  --publish 8080:80 \
  wordpress
```