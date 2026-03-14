package com.mycomp.krishi.service.api;

import com.mycomp.krishi.web.v1.model.RatingReviewRequest;
import com.mycomp.krishi.web.v1.model.RatingReviewResponse;

import java.util.List;

public interface RatingReviewService {
	RatingReviewResponse addRatingReview(RatingReviewRequest request);
	List<RatingReviewResponse> getReviewsForUser(Long userId);
	List<RatingReviewResponse> getReviewsForProduct(Long farmerProductId);
	Double getAverageRatingForUser(Long userId);
}
