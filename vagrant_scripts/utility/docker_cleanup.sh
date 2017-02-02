#!/bin/bash

cleanType=$1

if [[ -z "${cleanType}" ]]; then

    echo "cleaning all"
    docker rm -v $(docker ps --filter status=exited -q 2>/dev/null) 2>/dev/null
    docker rmi $(docker images --filter dangling=true -q 2>/dev/null) 2>/dev/null

elif [[ "${cleanType}" == "images" ]]; then

    echo "cleaning images"
    docker rmi $(docker images --filter dangling=true -q 2>/dev/null) 2>/dev/null

elif [[ "${cleanType}" == "containers" ]]; then

    echo "cleaning containers"
    docker rm -v $(docker ps --filter status=exited -q 2>/dev/null) 2>/dev/null

else
    echo "cleaning all"
    docker rm -v $(docker ps --filter status=exited -q 2>/dev/null) 2>/dev/null
    docker rmi $(docker images --filter dangling=true -q 2>/dev/null) 2>/dev/null
fi

exit 0