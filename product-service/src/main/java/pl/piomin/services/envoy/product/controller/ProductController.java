package pl.piomin.services.envoy.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.envoy.product.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	private List<Product> products = new ArrayList<>();

	@GetMapping
	public List<Product> findAll() {
		return products;
	}

	@GetMapping("/{id}")
	public Product findById(@RequestParam("id") Long id) {
		return products.stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	@PostMapping
	public Product add(@RequestBody Product p) {
		p.setId((long) (products.size() + 1));
		products.add(p);
		return p;
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		List<Product> p = products.stream().filter(it -> it.getId().equals(id)).collect(Collectors.toList());
		products.removeAll(p);
	}

	@PutMapping
	public void update(@RequestBody Product p) {
		Product product = products.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
		products.set(products.indexOf(product), p);
	}

}
