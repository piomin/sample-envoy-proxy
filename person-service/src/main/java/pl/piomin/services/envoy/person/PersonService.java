package pl.piomin.services.envoy.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PersonService {

	public static void main(String[] args) {
		SpringApplication.run(PersonService.class, args).registerShutdownHook();
	}

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
