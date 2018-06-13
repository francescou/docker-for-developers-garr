```bash
docker run --rm --name redis --publish 6379:6379 redis:alpine
```

```bash
docker build --tag garr-workshop/thermostat-trouble:1.0 .
```

```bash
docker run --link redis:redis \
  --name webapp \
  --publish 8080:8080 \
  --env REDIS_HOST=redis \
  --memory 300m \
  garr-workshop/thermostat-trouble:1.0
```

# provare con memory 500
