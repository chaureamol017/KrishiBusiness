/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;

import java.util.List;

/**
 *
 * @author Amol
 */
public interface FarmerProductBidService {

	FarmerProductBidModel saveFarmerProductBid(FarmerProductBidModel model);

	FarmerProductBidModel updateFarmerProductBid(FarmerProductBidModel model);

	List<FarmerProductBidModel> getAllFarmerProductBids();

	FarmerProductBidModel getFarmerProductBid(Long farmerProductBidId);

	Boolean deleteFarmerProductBid(Long farmerProductBidId);

	FarmerProductBidModel acceptBid(Long farmerProductBidId);

	List<FarmerProductBidModel> getFarmerProductBidsByProductIdAndBuyerUserId(Long productId, Long buyerUserId);

	List<FarmerProductBidModel> getFarmerProductBidsByFarmerProductId(Long farmerProductId);

}
