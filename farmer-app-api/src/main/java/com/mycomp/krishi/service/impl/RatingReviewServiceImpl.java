package com.mycomp.krishi.service.impl;

import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.persistence.entity.RatingReview;
import com.mycomp.krishi.persistence.entity.User;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.repository.RatingReviewRepository;
import com.mycomp.krishi.persistence.repository.UserRepository;
import com.mycomp.krishi.service.api.RatingReviewService;
import com.mycomp.krishi.web.v1.model.RatingReviewRequest;
import com.mycomp.krishi.web.v1.model.RatingReviewResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RatingReviewServiceImpl implements RatingReviewService {

	private final RatingReviewRepository ratingReviewRepository;
	private final UserRepository userRepository;
	private final FarmerProductRepository farmerProductRepository;

	@Autowired
	public RatingReviewServiceImpl(RatingReviewRepository ratingReviewRepository,
								   UserRepository userRepository,
								   FarmerProductRepository farmerProductRepository) {
		this.ratingReviewRepository = ratingReviewRepository;
		this.userRepository = userRepository;
		this.farmerProductRepository = farmerProductRepository;
	}

	@Override
	public RatingReviewResponse addRatingReview(RatingReviewRequest request) {
		// Check if user already reviewed this product
		List<RatingReview> existing = ratingReviewRepository
				.findByReviewerUserIdAndFarmerProductId(request.getReviewerUserId(), request.getFarmerProductId());
		if (!existing.isEmpty()) {
			throw new RuntimeException("You have already reviewed this product");
		}

		RatingReview entity = new RatingReview();
		entity.setFarmerProductId(request.getFarmerProductId());
		entity.setReviewerUserId(request.getReviewerUserId());
		entity.setRatedUserId(request.getRatedUserId());
		entity.setRating(request.getRating());
		entity.setReview(request.getReview());
		entity.setCreatedOn(new Date());

		RatingReview saved = ratingReviewRepository.save(entity);
		return toResponse(saved);
	}

	@Override
	public List<RatingReviewResponse> getReviewsForUser(Long userId) {
		List<RatingReview> reviews = ratingReviewRepository.findByRatedUserId(userId);
		return toResponseList(reviews);
	}

	@Override
	public List<RatingReviewResponse> getReviewsForProduct(Long farmerProductId) {
		List<RatingReview> reviews = ratingReviewRepository.findByFarmerProductId(farmerProductId);
		return toResponseList(reviews);
	}

	@Override
	public Double getAverageRatingForUser(Long userId) {
		Double avg = ratingReviewRepository.getAverageRatingForUser(userId);
		return avg != null ? Math.round(avg * 100.0) / 100.0 : 0.0;
	}

	private List<RatingReviewResponse> toResponseList(List<RatingReview> reviews) {
		List<RatingReviewResponse> responses = new ArrayList<>();
		for (RatingReview review : reviews) {
			responses.add(toResponse(review));
		}
		return responses;
	}

	private RatingReviewResponse toResponse(RatingReview entity) {
		RatingReviewResponse response = new RatingReviewResponse();
		response.setRatingId(entity.getRatingId());
		response.setFarmerProductId(entity.getFarmerProductId());
		response.setReviewerUserId(entity.getReviewerUserId());
		response.setRatedUserId(entity.getRatedUserId());
		response.setRating(entity.getRating());
		response.setReview(entity.getReview());
		response.setCreatedOn(entity.getCreatedOn());

		response.setReviewerName(getUserName(entity.getReviewerUserId()));
		response.setRatedUserName(getUserName(entity.getRatedUserId()));

		Optional<FarmerProduct> fpOpt = farmerProductRepository.findById(entity.getFarmerProductId());
		if (fpOpt.isPresent() && fpOpt.get().getProduct() != null) {
			response.setProductName(fpOpt.get().getProduct().getName());
		}

		return response;
	}

	private String getUserName(Long userId) {
		if (userId == null) return "";
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			return (user.getFirstName() != null ? user.getFirstName() : "") +
				   (user.getLastName() != null ? " " + user.getLastName() : "");
		}
		return "";
	}
}
