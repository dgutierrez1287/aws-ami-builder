#!/bin/bash

# args
groovyVersion=$1
gradleVersion=$2
sourceDir=$3

# vars
tag="ami-builder-build"
dockerFile="Dockerfile.build"

errorFlag="false"

pushd ${sourceDir}/app

    docker build -t ${tag} -f ${dockerFile} .

    if [ $? -ne 0 ]; then
        errorFlag="true"
    fi

popd

if [[ "${errorFlag}" == "true" ]]; then
    echo "build of build image failed"
    exit 1
else
    exit 0
fi