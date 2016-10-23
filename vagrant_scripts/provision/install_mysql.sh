#!/bin/bash

####
# install_mysql.sh
# this will install and set up mysql and all the tools needed
####

mysqlVersion=57
rootPassword=root

sudo rpm -ivh http://dev.mysql.com/get/mysql${mysqlVersion}-community-release-el7-7.noarch.rpm

sudo yum install -y mysql-community-server

sudo systemctl enable mysqld
sudo service mysqld start

# get temp root password from the log
tempPassword=$(sudo cat /var/log/mysqld.log | grep "temporary password" | grep -o "localhost: .*$" | awk '{print $2}')

# alter password policy and set local root password
mysql -uroot -p${tempPassword} --connect-expired-password -e 'SET GLOBAL validate_password_policy=LOW;'
mysql -uroot -p${tempPassword} --connect-expired-password -e 'SET GLOBAL validate_password_length=4;'
mysql -uroot -p${tempPassword} --connect-expired-password -e "SET PASSWORD = PASSWORD('${rootPassword}');"

# set global root DB user
mysql -uroot -p${rootPassword} -e "CREATE USER 'root'@'%' IDENTIFIED BY '${rootPassword}';"
mysql -uroot -p${rootPassword} -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION"

# change bind address
sudo sed -i 's/bind-address.*/#bind-address = 0.0.0.0/' /etc/my.cnf

# restart mysql
sudo service mysqld restart