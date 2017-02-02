#!/bin/bash

# arg to var
mysqlVersion=$1

# check if the mysql container is running and stop it
mysqlRunning=$(docker ps | grep mysql)

if [[ ! -z "${mysqlRunning}" ]]; then

    docker stop mysql
    docker rm mysql
fi

# start the mysql container with the correct version
docker run -d -p 3306:3306 --name mysql --restart=always \
-e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=ami_builder \
-v /home/vagrant/mysql-data/${mysqlVersion}:/var/lib/mysql mysql:${mysqlVersion}