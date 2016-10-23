#!/bin/bash

####
# install_java8.sh
# this will install and set up java 8 and all the tools needed
####

jdkUrl="http://download.oracle.com/otn-pub/java/jdk/8u112-b15/jdk-8u112-linux-x64.rpm"
jdkRpm="jdk-8u112-linux-x64.rpm"

sudo yum install -y wget

wget --quiet --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" ${jdkUrl}

sudo rpm -ivh ${jdkRpm}

