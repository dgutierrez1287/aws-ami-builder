#!/bin/bash

###
# setup_docker.sh
# this will install docker and do any configuration needed for docker
###

curl -fsSL https://get.docker.com/ | sudo sh

sudo systemctl enable docker
sudo systemctl start docker

sudo usermod -aG docker vagrant
