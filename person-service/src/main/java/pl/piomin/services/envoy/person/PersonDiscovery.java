package pl.piomin.services.envoy.person;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.annotation.Configuration;

import pl.piomin.services.envoy.person.model.DiscoveryHost;

@Configuration
@EnableDiscoveryClient(autoRegister = true)
public class PersonDiscovery {

	@Value("${server.port}")
	int port;
	
	private ServiceRegistry<DiscoveryHost> registry;

	@Autowired
	public PersonDiscovery(ServiceRegistry<DiscoveryHost> registry) {
		this.registry = registry;
	}
	
    public void register() {
    	System.out.println("register()");
    	try {
	        DiscoveryHost registration = new DiscoveryHost();
	        registration.setIpAddress(InetAddress.getLocalHost().getHostName());
	        registration.setPort(port);
	        registration.setService("person");
	        this.registry.register(registration);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
