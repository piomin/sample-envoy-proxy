FROM lyft/envoy
RUN apt-get update
COPY envoy.json /etc/envoy.json
CMD /usr/local/bin/envoy -c /etc/envoy.json --service-cluster envoy-demo --service-node envoy-demo
