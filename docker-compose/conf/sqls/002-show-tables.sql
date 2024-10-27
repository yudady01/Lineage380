SHOW databases;
USE `l1jtw`;
SHOW tables;

select '----------------------';
set global time_zone = '+8:00'; ##修改mysql全局时区为北京时间，即我们所在的东8区
set time_zone = '+8:00'; ##修改当前会话时区
flush privileges; #立即生效
select '----------------------';
select @@GLOBAL.time_zone, @@SESSION.time_zone;
select '----------------------';
show global variables like '%time%zone%';
select '----------------------';
SELECT CURRENT_TIMESTAMP;
SELECT CURRENT_TIMESTAMP();
SELECT NOW();







