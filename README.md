# Front Application Usage

### To create and store a new random car:
> GET /generatecar

### To retrieve all stored cars:
> GET /cars

### To test http communication between front and back applications
> GET /healthz

### To get a "Hello world" from backend app
> GET /

# Back Application Usage

### To create and store a new random car:
> POST /api/v1/car  (without any content body)

### To retrieve all stored cars:
> GET /api/v1/car

### To test database connection between back app and postgresql database
> GET /healthz

### To get a "Hello World"
> GET /hello

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