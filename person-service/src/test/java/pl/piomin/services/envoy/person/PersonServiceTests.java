package pl.piomin.services.envoy.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import pl.piomin.services.envoy.person.model.Gender;
import pl.piomin.services.envoy.person.model.Person;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonServiceTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldAddProduct() {
        Person p = new Person();
        p.setFirstName("XXX");
        p.setLastName("YYY");
        p.setAge(50);
        p.setGender(Gender.MALE);
        p = restTemplate.postForObject("/person", p, Person.class);
        assertNotNull(p);
        assertNotNull(p.getId());
    }
}
