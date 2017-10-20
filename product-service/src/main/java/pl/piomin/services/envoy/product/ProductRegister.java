package pl.piomin.services.envoy.product;

import java.net.InetAddress;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.piomin.services.envoy.product.model.DiscoveryHost;
import pl.piomin.services.envoy.product.model.DiscoveryHosts;

@Service
public class ProductRegister implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRegister.class);

	private String ip;
	@Value("${server.port}")
	private int port;
	@Value("${spring.application.name}")
	private String appName;
	@Value("${envoy.discovery.url}")
	private String discoveryUrl;
	
	@Autowired
	RestTemplate template;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LOGGER.info("ProductRegister.register");
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			DiscoveryHost host = new DiscoveryHost();
			host.setPort(port);
			host.setIpAddress(ip);
			template.postForObject(discoveryUrl + "/v1/registration/{service}", host, DiscoveryHosts.class, appName);
		} catch (Exception e) {
			LOGGER.error("Error during registration", e);
		}
	}

	@PreDestroy
	public void destroy() {
		try {
			template.delete(discoveryUrl + "/v1/registration/{service}/{ip}/", appName, ip);
			LOGGER.info("ProductRegister.unregistered: service={}, ip={}", appName, ip);
		} catch (Exception e) {
			LOGGER.error("Error during unregistration", e);
		}
	}
	
}
