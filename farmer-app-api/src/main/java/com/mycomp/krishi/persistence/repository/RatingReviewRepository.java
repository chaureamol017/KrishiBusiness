package com.mycomp.krishi.persistence.repository;

import com.mycomp.krishi.persistence.entity.RatingReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {
	List<RatingReview> findByRatedUserId(Long ratedUserId);
	List<RatingReview> findByFarmerProductId(Long farmerProductId);
	List<RatingReview> findByReviewerUserIdAndFarmerProductId(Long reviewerUserId, Long farmerProductId);

	@Query("SELECT AVG(r.rating) FROM RatingReview r WHERE r.ratedUserId = :userId")
	Double getAverageRatingForUser(@Param("userId") Long userId);
}
