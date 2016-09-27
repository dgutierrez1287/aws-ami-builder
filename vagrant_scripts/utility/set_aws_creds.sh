#!/bin/bash

####
# set_aws_creds.sh <accesKey> <secretKey>
# This will set up the aws access key and secret key to match what is used 
# by gradle on the local machine
####

# args 
awsAccessKey=$1
awsSecretKey=$2

# script vars
credsDir="/home/vagrant/.aws"
credsFile="${credsDir}/credentials"
configFile="${credsDir}/config"

# check for .aws directory and create it if its not there
if [ ! -d $credsDir ]; then
    mkdir $credsDir
fi

# clean current file and set up credentials file
if [ -f $credsFile ]; then 
    rm -f $credsFile
fi

echo "[default]" > $credsFile
echo "aws_access_key_id = ${awsAccessKey}" >> $credsFile
echo "aws_secret_access_key = ${awsSecretKey}" >> $credsFile