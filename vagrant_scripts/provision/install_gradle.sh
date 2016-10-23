#!/bin/bash

####
# install_gradle.sh
# this will install and set up gradle and all the tools needed
####

gradleVersion="3.1"

sudo yum -y install unzip

mkdir /home/vagrant/bin

wget --quiet https://services.gradle.org/distributions/gradle-${gradleVersion}-all.zip

unzip gradle-${gradleVersion}-all.zip -d /home/vagrant/bin

echo " " >> /home/vagrant/.bashrc
echo "# gradle" >> /home/vagrant/.bashrc
echo "GRADLE_HOME=/home/vagrant/bin/gradle-${gradleVersion}" >> /home/vagrant/.bashrc
echo "PATH=\$HOME/bin/gradle-${gradleVersion}/bin:\$PATH" >> /home/vagrant/.bashrc