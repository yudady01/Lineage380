GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' identified by 'root' with grant option;
FLUSH PRIVILEGES;

CREATE USER 'tommy'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'tommy'@'%' identified by '123456' with grant option;
FLUSH PRIVILEGES;


CREATE DATABASE IF NOT EXISTS `l1jtw`;
USE `l1jtw`;
SHOW tables;
SHOW databases;









