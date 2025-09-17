package com.example.customer.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer.service.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	Product findByCategory(String category);

}
