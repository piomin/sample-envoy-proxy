FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/person-service.jar person-service.jar
ENTRYPOINT ["java", "-jar", "/person-service.jar"]
EXPOSE 9300