package com.mycomp.krishi.web.v1.model;

import java.util.Date;

public class RatingReviewRequest {
	private Long ratingId;
	private Long farmerProductId;
	private Long reviewerUserId;
	private Long ratedUserId;
	private int rating;
	private String review;

	public Long getRatingId() { return ratingId; }
	public void setRatingId(Long ratingId) { this.ratingId = ratingId; }

	public Long getFarmerProductId() { return farmerProductId; }
	public void setFarmerProductId(Long farmerProductId) { this.farmerProductId = farmerProductId; }

	public Long getReviewerUserId() { return reviewerUserId; }
	public void setReviewerUserId(Long reviewerUserId) { this.reviewerUserId = reviewerUserId; }

	public Long getRatedUserId() { return ratedUserId; }
	public void setRatedUserId(Long ratedUserId) { this.ratedUserId = ratedUserId; }

	public int getRating() { return rating; }
	public void setRating(int rating) { this.rating = rating; }

	public String getReview() { return review; }
	public void setReview(String review) { this.review = review; }
}
