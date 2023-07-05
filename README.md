

## Deploy Database

```bash
kubectl apply -f database/
```

## Deploy Backend

```bash
cd back/
docker build -t ghcr.io/do3-2023/vfo-kube/back:latest . --file Dockerfile
docker push ghcr.io/do3-2023/vfo-kube/back:latest
kubectl apply -f infra/
```