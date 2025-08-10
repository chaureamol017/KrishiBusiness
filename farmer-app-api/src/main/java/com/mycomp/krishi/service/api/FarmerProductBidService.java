package com.mycomp.krishi.service.api;

import com.mycomp.krishi.service.model.FarmerProductBidModel;
public interface FarmerProductBidService {

	FarmerProductBidModel save(FarmerProductBidModel model);
	FarmerProductBidModel update(FarmerProductBidModel model);
	FarmerProductBidModel getById(Long id);
	FarmerProductBidModel getBid(Long buyerUserId, Long farmerProductId);
	Boolean deleteById(Long id);
}

