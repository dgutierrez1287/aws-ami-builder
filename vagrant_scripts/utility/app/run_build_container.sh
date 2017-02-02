#!/bin/bash

# args
awsAccessKey=$1
awsSecretKey=$2
sourceDir=$3

# vars
imageName="ami-builder-build"
containerName="ami-builder-build"

docker run -e AWS_ACCESS_KEY=${awsAccessKey} -e AWS_SECRET_KEY=${awsSecretKey} \
-v ${sourceDir}:/root/src -v ${sourceDir}/app/gradle_cache:/root/.gradle \
--net="bridge" --name ${containerName} ${imageName}

exit 0