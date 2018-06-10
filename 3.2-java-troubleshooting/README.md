```bash
docker run --rm --name redis -p 6379:6379 redis:alpine
```

```bash
docker build -t garr-workshop/thermostat-trouble:1.0 .
```

```bash
docker run --link redis:redis \
  --name webapp \
  -p 8080:8080 \
  -e REDIS_HOST=redis \
  -m 300m \
  --rm \
  garr-workshop/thermostat-trouble:1.0
```
