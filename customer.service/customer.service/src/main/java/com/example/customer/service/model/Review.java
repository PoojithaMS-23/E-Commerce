package com.example.customer.service.model;

import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="reviews")
public class Review {
	private String userId;
	private String productId;
	private String rating;
	public Review(String userId, String productId, String rating, String comment, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	private String comment;
	private LocalDateTime createdAt;
	
}