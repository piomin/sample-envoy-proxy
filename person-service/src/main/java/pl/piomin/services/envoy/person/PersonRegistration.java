package pl.piomin.services.envoy.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.piomin.services.envoy.person.model.DiscoveryHost;
import pl.piomin.services.envoy.person.model.DiscoveryHosts;

@Service
public class PersonRegistration implements ServiceRegistry<DiscoveryHost> {

	@Autowired
	RestTemplate template;
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deregister(DiscoveryHost arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getStatus(DiscoveryHost arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(DiscoveryHost host) {
		template.postForObject("http://localhost:9200/v1/registration/{service}", host, DiscoveryHosts.class, "person");		
	}

	@Override
	public void setStatus(DiscoveryHost arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
