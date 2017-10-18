package pl.piomin.services.envoy.discovery.model;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryHosts {

	private List<DiscoveryHost> hosts = new ArrayList<>();

	public List<DiscoveryHost> getHosts() {
		return hosts;
	}

	public void setHosts(List<DiscoveryHost> hosts) {
		this.hosts = hosts;
	}

}
