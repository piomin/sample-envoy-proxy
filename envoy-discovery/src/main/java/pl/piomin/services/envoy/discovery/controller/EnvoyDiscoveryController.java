package pl.piomin.services.envoy.discovery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.envoy.discovery.model.DiscoveryHost;
import pl.piomin.services.envoy.discovery.model.DiscoveryHosts;

@RestController
public class EnvoyDiscoveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnvoyDiscoveryController.class);

    private final Map<String, List<DiscoveryHost>> hosts = new HashMap<>();

    @GetMapping(value = "/v1/registration/{serviceName}")
    public DiscoveryHosts getHostsByServiceName(@PathVariable("serviceName") String serviceName) {
        LOGGER.info("getHostsByServiceName: service={}", serviceName);
        DiscoveryHosts hostsList = new DiscoveryHosts();
        hostsList.setHosts(hosts.get(serviceName));
        LOGGER.info("getHostsByServiceName: hosts={}", hostsList);
        return hostsList;
    }

    @PostMapping("/v1/registration/{serviceName}")
    public void addHost(@PathVariable("serviceName") String serviceName, @RequestBody DiscoveryHost host) {
        LOGGER.info("addHost: service={}, body={}", serviceName, host);
        List<DiscoveryHost> tmp = hosts.get(serviceName);
        if (tmp == null)
            tmp = new ArrayList<>();
        tmp.add(host);
        hosts.put(serviceName, tmp);
    }

    @DeleteMapping("/v1/registration/{serviceName}/{ipAddress}")
    public void deleteHost(@PathVariable("serviceName") String serviceName, @PathVariable("ipAddress") String ipAddress) {
        LOGGER.info("deleteHost: service={}, ip={}", serviceName, ipAddress);
        List<DiscoveryHost> tmp = hosts.get(serviceName);
        if (tmp != null) {
            Optional<DiscoveryHost> optHost = tmp.stream().filter(it -> it.getIpAddress().equals(ipAddress)).findFirst();
            optHost.ifPresent(tmp::remove);
            hosts.put(serviceName, tmp);
        }
    }

}
