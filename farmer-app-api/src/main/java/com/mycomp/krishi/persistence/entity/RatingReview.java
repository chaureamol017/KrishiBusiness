package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings_reviews")
public class RatingReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private Long ratingId;

	@Column(name = "farmer_product_id")
	private Long farmerProductId;

	@Column(name = "reviewer_user_id")
	private Long reviewerUserId;

	@Column(name = "rated_user_id")
	private Long ratedUserId;

	@Column(name = "rating")
	private int rating;

	@Column(name = "review")
	private String review;

	@Column(name = "created_on")
	private Date createdOn;

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

	public Date getCreatedOn() { return createdOn; }
	public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }
}
