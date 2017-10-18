FROM openjdk:alpine
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/envoy-discovery.jar envoy-discovery.jar
ENTRYPOINT ["java", "-jar", "/envoy-discovery.jar"]
EXPOSE 9200