#!/bin/bash

####
# dev_env_setup.sh
# this will install and setup anything else needed by the dev environment
####

sudo yum -y install wget
mkdir installers

# install jq
# this is needed by some scripts to install and recheck dependencies
wget https://github.com/stedolan/jq/releases/download/jq-1.5/jq-linux64 -O installers/jq
chmod 755 installers/jq
sudo mv installers/jq /bin/

# install awscli 
sudo pip install awscli
