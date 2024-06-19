# Font Vincent
## Mise en place de RKE2
Pour ma part la mise en place de RKE2 a bien fonctionné, j'ai suivi cette doc: https://docs.rke2.io/install/quickstart

## Cilium
Par contre c'est au moment de la mise en place de Cilium où ça s'est beaucoup compliqué car j'ai suivi cette documentation: https://docs.cilium.io/en/stable/gettingstarted/k8s-install-default/

Mais ça ne marchais pas, je n'ai pas réussi à savoir pourquoi mais au moment de faire le `cilium status --wait`, Cilium ne passait jamais en **OK**.

J'ai donc dû supprimer Cilium, désinstaller RKE2 et tout refaire et cette fois ci, Cilium a fonctionné et est bien passé en **OK**

J'avais donc peut-être raté une étape qui avait causé ce problème.

## Deployment
J'ai donc pu déployer mon application sur mon cluster RKE2, les images sont sur ghcr.io, il y a les versions 1,2,3 et 4 pour le downtime: https://github.com/orgs/do3-2023/packages?repo_name=vfo-kube, j'ai eu besoin de rien changer dans mes fichiers de config k8s, tout marche...

## Downtime
Pour la mise en place du Downtime, j'ai bien changé le code de l'API et du Front pour pouvoir traiter des **Personnes** et bien évidemment créer les différentes versions.

Accessible sur les branches:
- downtime-v1
- downtime-v2
- downtime-v3
- downtime-v4

## WASM
Pour le WASM, j'ai essayé plusieurs outils:
- bytecoder
- cheerpj
- TeaVM

# Documentation
# Front Application Usage

### To create and store a new random person:
> GET /generateperson

### To retrieve all stored persons:
> GET /persons

### To test http communication between front and back applications
> GET /healthz

### To get a "Hello world" from backend app
> GET /

# Back Application Usage

### To create and store a new random car:
> POST /api/v1/person  (without any content body)

### To retrieve all stored cars:
> GET /api/v1/person

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