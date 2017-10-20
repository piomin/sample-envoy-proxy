FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/person-service.jar person-service.jar
ENV port 9300
ENV discoveryUrl http://192.168.99.100:9200
ENTRYPOINT ["java", "-jar", "-Dport=${port}", "-Denvoy.discovery.url=${discoveryUrl}", "/person-service.jar"]
EXPOSE ${port}