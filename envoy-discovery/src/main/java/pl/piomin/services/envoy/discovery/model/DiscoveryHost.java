package pl.piomin.services.envoy.discovery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscoveryHost {

	@JsonProperty("ip_address")
	private String ipAddress;
	private String port;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
