#!/bin/bash

# entrypoint script for the ami-builder
# app container


# export env variables for tool home locations
export JAVA_HOME=/usr/java/latest
export GROOVY_HOME=/opt/groovy-${GROOVY_VERSION}

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

# make directory for app logs
mkdir /root/logs


java -jar ami-builder-${AMI_BUILDER_VERSION}.jar
