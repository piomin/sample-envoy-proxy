FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/product-service.jar product-service.jar
ENV port 9400
ENTRYPOINT ["java", "-jar", "-Dport=${port}", "/product-service.jar"]
EXPOSE ${port}