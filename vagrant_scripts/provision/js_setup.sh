#!/bin/bash

####
# js_setup.sh
# this will install and set up node and all the tools meeded
# for angular
####

## Vars
nodeType="LTS"   # set version for node

# install build tools for extentions
sudo yum -y install gcc-c++ make gcc automake

# install either LTS or latest release of node
if [[ "${nodeType}" == "LTS" ]]; then
  sudo curl --silent --location https://rpm.nodesource.com/setup_4.x | sudo bash -
else
  sudo curl --silent --location https://rpm.nodesource.com/setup_6.x | sudo bash -
fi

# install node
sudo yum install -y nodejs

# update npm version
sudo npm install npm -g
