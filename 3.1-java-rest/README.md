```bash
docker run --rm --name redis -p 6379:6379 redis:alpine
```

```bash

docker build -t garr-workshop/thermostat:1.0 .
docker run --link redis:redis --name webapp -p 8080:8080 --rm garr-workshop/thermostat:1.0
```