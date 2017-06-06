#!/bin/sh

nohup mongod --dbpath /data/db &
sleep 10s
java -jar /app/datascience-importer.jar
java -jar /app/datascience-web.jar