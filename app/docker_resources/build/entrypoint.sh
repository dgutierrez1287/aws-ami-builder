#!/bin/bash

# entrypoint script for the ami-builder
# app build container

# export env variables for tool home locations
export JAVA_HOME=/usr/java/latest
export GROOVY_HOME=/opt/groovy-${GROOVY_VERSION}
export GRADLE_HOME=/opt/gradle-${GRADLE_VERSION}

# set AWS Creds if they need to be set
if [[ "${AWS_ACCESS_KEY}" != "unset" ]]; then

    if [[ "${AWS_SECRET_KEY}" == "unset" ]]; then
        echo "Access Key set but Secret Key not found, exiting"
        exit 6
    else
        mkdir /root/.aws
        echo "[default]" > /root/.aws/credentials
        echo "aws_access_key_id = ${AWS_ACCESS_KEY}" >> /root/.aws/credentials
        echo "aws_secret_access_key= ${AWS_SECRET_KEY}" >> /root/.aws/credentials
    fi
else
    echo "AWS sdk keys unset, assuming IAM Role"
fi

pushd /root/src

gradle :app:build

popd

