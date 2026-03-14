package com.mycomp.krishi.web.v1.model;

import java.util.Date;

public class RatingReviewResponse {
	private Long ratingId;
	private Long farmerProductId;
	private Long reviewerUserId;
	private String reviewerName;
	private Long ratedUserId;
	private String ratedUserName;
	private int rating;
	private String review;
	private Date createdOn;
	private String productName;

	public Long getRatingId() { return ratingId; }
	public void setRatingId(Long ratingId) { this.ratingId = ratingId; }

	public Long getFarmerProductId() { return farmerProductId; }
	public void setFarmerProductId(Long farmerProductId) { this.farmerProductId = farmerProductId; }

	public Long getReviewerUserId() { return reviewerUserId; }
	public void setReviewerUserId(Long reviewerUserId) { this.reviewerUserId = reviewerUserId; }

	public String getReviewerName() { return reviewerName; }
	public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

	public Long getRatedUserId() { return ratedUserId; }
	public void setRatedUserId(Long ratedUserId) { this.ratedUserId = ratedUserId; }

	public String getRatedUserName() { return ratedUserName; }
	public void setRatedUserName(String ratedUserName) { this.ratedUserName = ratedUserName; }

	public int getRating() { return rating; }
	public void setRating(int rating) { this.rating = rating; }

	public String getReview() { return review; }
	public void setReview(String review) { this.review = review; }

	public Date getCreatedOn() { return createdOn; }
	public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }

	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName; }
}
