#!/bin/bash

####
# install_groovy.sh
# this will install and set up groovy and all the tools needed
####

groovyVersion="2.4.7"

sudo yum -y install unzip

mkdir /home/vagrant/bin

wget --quiet https://dl.bintray.com/groovy/maven/apache-groovy-sdk-${groovyVersion}.zip

unzip apache-groovy-sdk-${groovyVersion}.zip -d /home/vagrant/bin

echo " " >> /home/vagrant/.bashrc
echo "# groovy" >> /home/vagrant/.bashrc
echo "GROOVY_HOME=/home/vagrant/bin/groovy-${groovyVersion}" >> /home/vagrant/.bashrc
echo "PATH=\$HOME/bin/groovy-${groovyVersion}/bin:\$PATH" >> /home/vagrant/.bashrc