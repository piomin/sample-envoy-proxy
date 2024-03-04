package pl.piomin.services.envoy.product.controller;

import org.springframework.web.bind.annotation.*;
import pl.piomin.services.envoy.product.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> findAll() {
        return products;
    }

    @GetMapping("/{id}")
    public Product findById(@RequestParam("id") Long id) {
        return products.stream().filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PostMapping
    public Product add(@RequestBody Product p) {
        p.setId((long) (products.size() + 1));
        products.add(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") Long id) {
        List<Product> p = products.stream()
                .filter(it -> it.getId().equals(id))
                .toList();
        products.removeAll(p);
    }

    @PutMapping
    public void update(@RequestBody Product p) {
        Product product = products.stream()
                .filter(it -> it.getId().equals(p.getId()))
                .findFirst()
                .orElseThrow();
        products.set(products.indexOf(product), p);
    }

}
