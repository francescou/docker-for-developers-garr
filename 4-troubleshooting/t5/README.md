# listeners

```
docker run --rm --name redis redis:alpine --port 7777
```

```
docker run --tty --interactive  --rm --link redis:redis  alpine  sh
```

```bash
nc -vvv redis 6379

# nc: redis (172.17.0.2:6379): Connection refused
#sent 0, rcvd 0


```bash
nc -vvv redis 7777

#redis (172.17.0.2:7777) open

```
