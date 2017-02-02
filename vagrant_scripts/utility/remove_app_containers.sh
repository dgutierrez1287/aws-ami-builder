#!/bin/bash

containerType=$1
buildContainerName="ami-builder-build"
appContainerName="ami-builder-app"

if [[ -z "${containerType}" ]]; then

    docker rm ${buildContainerName}
    docker rm ${appContainerName}

elif [[ "${containerType}" == "build" ]]; then

    docker rm ${buildContainerName}

elif [[ "${containerType}" == "app" ]]; then

    docker rm ${appContainerName}
else
    docker rm ${buildContainerName}
    dokcer rm ${appContainerName}
fi

exit 0