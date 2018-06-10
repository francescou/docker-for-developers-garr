```bash
docker run --rm --name redis --publish 6379:6379 redis:alpine
```

```bash

docker build --tag garr-workshop/thermostat:1.0 .
docker run --link redis:redis --name webapp --publish 8080:8080 --rm garr-workshop/thermostat:1.0
```