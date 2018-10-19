FROM ubuntu:18.04

RUN apt-get update

RUN apt-get install -y nginx

ADD index.html /var/www/html/index.html

RUN echo "daemon off;" >> /etc/nginx/nginx.conf

CMD service nginx start
