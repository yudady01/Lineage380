#!/usr/bin/env bash

cd /docker-entrypoint-initdb.d

ls -la

echo 'mysql init 000-create-databases.sql done ~~~~~'
echo 'mysql init 001-create-tables.sql done    ~~~~~'
echo 'mysql init 002-show-tables.sql   done    ~~~~~'
echo 'call init-database.sh done ~~~~~'
echo 'call init-database.sh done ~~~~~'
echo 'call init-database.sh done ~~~~~'


