package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.Product;
import polycomputer.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAll() {
		return productService.findAll();
	}
	
	@GetMapping("{productId}")
	public Product getOne(@PathVariable("productId") Integer productId) {
		return productService.findById(productId);
	}
	
	@PostMapping()
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@PutMapping("{productId}")
	public Product update(@PathVariable("productId") Integer productId,
			@RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("{productId}")
	public void delete(@PathVariable("productId") Integer productId) {
		productService.deleteById(productId);
	}
}
