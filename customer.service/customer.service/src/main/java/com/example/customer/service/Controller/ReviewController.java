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
import com.example.customer.service.model.Review;
import com.example.customer.service.repository.ProductRepository;
import com.example.customer.service.repository.ReviewRepository;

import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/reviews")


public class ReviewController {
	
	private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
	@Autowired
	private ReviewRepository reviewRepository;
	
	@PostMapping
	public Review createReview(@RequestBody Review user) {
		return reviewRepository.save(user);
	}
	
	@GetMapping
	public List<Review> getAllReview(){
		return reviewRepository.findAll();
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		
		Optional<Review> findproduct=reviewRepository.findById(id);
		if(findproduct.isEmpty()) {
			log.error("Failed to delete product"+id);
			return "Failed to delete product";
		}
		reviewRepository.deleteById(id);
		log.info("Product Deleted"+id);
		return "Product Deleted";
		
	}
	

}