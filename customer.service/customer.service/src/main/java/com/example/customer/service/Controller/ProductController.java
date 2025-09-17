package com.example.customer.service.Controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.service.model.Product;
import com.example.customer.service.repository.ProductRepository;

import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/products")


public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping
	public Product createUser(@RequestBody Product user) {
		return productRepository.save(user);
	}
	
	@GetMapping
	public List<Product> getAllUsers(){
		return productRepository.findAll();
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		
		Optional<Product> findproduct=productRepository.findById(id);
		if(findproduct.isEmpty()) {
			log.error("Failed to delete product"+id);
			return "Failed to delete product";
		}
		productRepository.deleteById(id);
		log.info("Product Deleted"+id);
		return "Product Deleted";
		
	}
	

}