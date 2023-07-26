# K3D Installation
```bash
wget -q -O - https://raw.githubusercontent.com/k3d-io/k3d/main/install.sh | bash
```
```bash
k3d cluster create <clustername>
```

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