

## Deploy Database

```bash
kubectl apply -f database/
```

## Deploy Backend

```bash
cd back/
docker build -t ghcr.io/do3-2023/vfo-kube/back .
docker push ghcr.io/do3-2023/vfo-kube/back
kubectl apply -f infra/
```

## Deploy Frontend

```bash
cd app-front/
docker build -t ghcr.io/do3-2023/vfo-kube/front .
docker push ghcr.io/do3-2023/vfo-kube/front
kubectl apply -f infra/
```