#!/bin/bash

# args
amiBuilderVersion=$1
groovyVersion=$2
sourceDir=$3

# vars
tag="ami-builder-app"
dockerFile="Dockerfile"

errorFlag="false"

pushd ${sourceDir}/app

    docker build -t ${tag} -f ${dockerFile} .

    if [ $? -ne 0 ]; then
        errorFlag="true"
    fi

popd

exit 0

#if [[ "${errorFlag}" == "true" ]]; then
#    echo "build of app image failed"
#    exit 1
#else
#    exit 0
#fi

