FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/person-service.jar person-service.jar
ENV port 9300
ENTRYPOINT ["java", "-jar", "-Dport=${port}", "/person-service.jar"]
EXPOSE ${port}