FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/product-service.jar product-service.jar
ENV port 9400
ENV discoveryUrl http://192.168.99.100:9200
ENTRYPOINT ["java", "-jar", "-Dport=${port}", "-Denvoy.discovery.url=${discoveryUrl}", "/product-service.jar"]
EXPOSE ${port}