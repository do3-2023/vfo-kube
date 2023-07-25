# Automatic Deploy
## Deploy all
```bash
chmod +x deploy_all.sh
./deploy_all.sh
```

## To re-deploy all without re-building docker images
```bash
chmod +x deploy_all.sh
./deploy_all.sh nobuild
```

# Manually Deploy
## Database
```bash
kubectl apply -f database/
```

## Backend app
```bash
kubectl apply -f back/infra/
```

## Front app
```bash
kubectl apply -f front/infra/
```