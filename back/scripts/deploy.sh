#!/bin/bash
echo -e "============\nDeploying backend app...\n============"
kubectl delete -f infra/ &> /dev/null
if [[ $1 != "nobuild" ]]; then
    chmod +x gradlew
    ./gradlew build
    docker build -t ghcr.io/do3-2023/vfo-kube/back .
    docker push ghcr.io/do3-2023/vfo-kube/back
fi
kubectl apply -f infra/