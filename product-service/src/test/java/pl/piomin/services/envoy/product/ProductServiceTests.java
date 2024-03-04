package pl.piomin.services.envoy.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import pl.piomin.services.envoy.product.model.Product;
import pl.piomin.services.envoy.product.model.ProductType;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldAddProduct() {
        Product p = new Product();
        p.setName("XXX");
        p.setType(ProductType.FOOD);
        p.setPrice(1000);
        p = restTemplate.postForObject("/product", p, Product.class);
        assertNotNull(p);
        assertNotNull(p.getId());
    }
}
