#!/bin/bash

containerType=$1
buildContainerName="ami-builder-build"
appContainerName="ami-builder-app"

if [[ -z "${containerType}" ]]; then

    docker stop ${buildContainerName}
    docker stop ${appContainerName}

elif [[ "${containerType}" == "build" ]]; then

    docker stop ${buildContainerName}

elif [[ "${containerType}" == "app" ]]; then

    docker stop ${appContainerName}
else
    docker stop ${buildContainerName}
    dokcer stop ${appContainerName}
fi

exit 0