package pl.piomin.services.envoy.discovery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscoveryHost {

	@JsonProperty("ip_address")
	private String ipAddress;
	private String lastCheckIn;
	private Integer port;
	private String revision;
	private String service;
	@JsonProperty("service_repo_name")
	private String serviceRepoName;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLastCheckIn() {
		return lastCheckIn;
	}

	public void setLastCheckIn(String lastCheckIn) {
		this.lastCheckIn = lastCheckIn;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceRepoName() {
		return serviceRepoName;
	}

	public void setServiceRepoName(String serviceRepoName) {
		this.serviceRepoName = serviceRepoName;
	}

}
