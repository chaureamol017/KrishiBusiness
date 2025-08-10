package com.mycomp.krishi.service.api;

import com.mycomp.krishi.service.model.FarmerProductBidModel;

import java.util.List;

public interface FarmerProductBidService {

	FarmerProductBidModel save(FarmerProductBidModel model);
	FarmerProductBidModel update(FarmerProductBidModel model);
	int acceptBid(Long productBidId);
	FarmerProductBidModel getById(Long id);
	FarmerProductBidModel getBidForBuyerAndProduct(Long buyerUserId, Long farmerProductId);
	List<FarmerProductBidModel> getBidForProduct(Long farmerProductId);
	Boolean deleteById(Long id);

}

