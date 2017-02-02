#!/bin/bash

# turn off firewall
sudo systemctl disable firewalld
sudo systemctl stop firewalld

# install epel
sudo rpm -iUvh http://dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-7-9.noarch.rpm

# install ansible
sudo yum -y install ansible