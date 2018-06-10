FROM php:7-apache

RUN docker-php-ext-install pdo pdo_mysql mysqli

COPY index.php /var/www/html/api/humidity/
