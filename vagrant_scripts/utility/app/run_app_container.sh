#!/bin/bash

# args
awsAccessKey=$1
awsSecretKey=$2

# vars
imageName="ami-builder-app"
containerName="ami-builder-app"

docker run -d -p 8080:8080 -e AWS_ACCESS_KEY=${awsAccessKey} -e AWS_SECRET_KEY=${awsSecretKey} \
-v /vagrant/app/build/libs:/root/ami-builder -v /vagrant/app/logs:/root/logs --link mysql:mysql \
--net="bridge" --name ${containerName} ${imageName}

exit 0
