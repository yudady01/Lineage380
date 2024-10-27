FROM mysql:5.7.37

USER root

COPY ./conf/mysql/my.cnf /etc/mysql/conf.d/my.cnf
RUN chmod 644 /etc/mysql/conf.d/*.cnf


EXPOSE 3306

USER mysql


