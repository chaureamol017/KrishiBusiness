/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.api;

import java.util.List;

import com.mycomp.krishi.service.model.FarmerProductBidModel;

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
