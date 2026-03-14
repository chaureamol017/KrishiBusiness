package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.service.api.RatingReviewService;
import com.mycomp.krishi.web.v1.model.RatingReviewRequest;
import com.mycomp.krishi.web.v1.model.RatingReviewResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/ratings")
public class RatingReviewController {

	private final RatingReviewService ratingReviewService;

	@Autowired
	public RatingReviewController(RatingReviewService ratingReviewService) {
		this.ratingReviewService = ratingReviewService;
	}

	@PostMapping
	public ResponseEntity<ApiResponse<RatingReviewResponse>> addRatingReview(@RequestBody RatingReviewRequest request) {
		try {
			RatingReviewResponse response = ratingReviewService.addRatingReview(request);
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Rating added successfully", response));
		} catch (RuntimeException ex) {
			return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(false, ex.getMessage(), null));
		}
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<ApiResponse<List<RatingReviewResponse>>> getReviewsForUser(@PathVariable("userId") Long userId) {
		List<RatingReviewResponse> reviews = ratingReviewService.getReviewsForUser(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Reviews fetched", reviews));
	}

	@GetMapping("/product/{farmerProductId}")
	public ResponseEntity<ApiResponse<List<RatingReviewResponse>>> getReviewsForProduct(@PathVariable("farmerProductId") Long farmerProductId) {
		List<RatingReviewResponse> reviews = ratingReviewService.getReviewsForProduct(farmerProductId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Reviews fetched", reviews));
	}

	@GetMapping("/average/{userId}")
	public ResponseEntity<ApiResponse<Double>> getAverageRating(@PathVariable("userId") Long userId) {
		Double average = ratingReviewService.getAverageRatingForUser(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Average rating fetched", average));
	}
}
