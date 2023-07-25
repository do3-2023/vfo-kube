#!/bin/bash
echo -e "============\nDeploying front app...\n============"
kubectl delete -f infra/ &> /dev/null
if [[ $1 != "nobuild" ]]; then
    docker build -t ghcr.io/do3-2023/vfo-kube/front .
    docker push ghcr.io/do3-2023/vfo-kube/front
fi
kubectl apply -f infra/
kubectl get svc/frontapp -n front