#!/bin/bash

####
# python_setup.sh
# This will set up the environment needed by the python lambda
# functions for testing
####

# install epel and pip
sudo rpm -iUvh http://dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-7-8.noarch.rpm   
sudo yum install -y python-devel
sudo yum install -y python-pip

# install boto3 and lambda local to get the box up to the base that lambda has
# other (dependencies will be installed later)
sudo pip install boto3
sudo pip install python-lambda-local

# install ipython for local testing
sudo pip install ipython

# install dependencies to compile python modules
sudo yum install -y libxml2-devel libxslt-devel

