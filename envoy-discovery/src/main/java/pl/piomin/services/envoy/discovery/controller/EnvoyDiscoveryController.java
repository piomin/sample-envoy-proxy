package pl.piomin.services.envoy.discovery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.envoy.discovery.model.DiscoveryHost;
import pl.piomin.services.envoy.discovery.model.DiscoveryHosts;

@RestController
public class EnvoyDiscoveryController {

	private Map<String, List<DiscoveryHost>> hosts = new HashMap<>();
	
	@GetMapping("/v1/registration/{serviceName}")
	public DiscoveryHosts getHostsByServiceName(@PathVariable("serviceName") String serviceName) {
		DiscoveryHosts hostsList = new DiscoveryHosts();
		hostsList.setHosts(hosts.get(serviceName));
		return hostsList;
	}
	
}
