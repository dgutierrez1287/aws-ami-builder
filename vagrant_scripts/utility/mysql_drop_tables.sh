#!/bin/bash

tables=$(mysql -h 127.0.0.1 -uroot -proot ami_builder -e "show tables" | awk '{ print $1}' | grep -v '^Tables')

for t in $tables
do
    echo "Dropping table $t"

    mysql -h 127.0.0.1 -uroot -proot ami_builder -e "SET FOREIGN_KEY_CHECKS=0; DROP TABLE $t; SET FOREIGN_KEY_CHECKS=1;"
done

exit 0