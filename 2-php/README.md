```
docker run \
  --env MYSQL_ROOT_PASSWORD=pippo \
  --volume $(pwd)/db/:/var/lib/mysql/ \
  --name database \
  mysql:5.6
```


```
docker run --name some-wordpress \
  --link some-mysql:wp-mysql \
  --env WORDPRESS_DB_HOST=wp-mysql \
  --env WORDPRESS_DB_PASSWORD=pippo \
  --publish 8080:80 \
  wordpress
```
