package com.example.customer.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer.service.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
	Review findByrating(String rating);

}
