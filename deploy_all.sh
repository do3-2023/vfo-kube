#!/bin/bash
echo -e "============\nDeploying Database...\n============"
kubectl delete -f database/ &> /dev/null
kubectl apply -f database/

echo -e "\n####################################################\n"

cd back/
chmod +x scripts/deploy.sh
./scripts/deploy.sh $1

echo -e "\n####################################################\n"

cd ../front/
chmod +x scripts/deploy.sh
./scripts/deploy.sh $1