/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.FarmerProductModel;

import java.util.List;

/**
 *
 * @author Amol
 */
public interface FarmerProductService {

	FarmerProductModel saveFarmerProduct(FarmerProductModel model);

	FarmerProductModel updateFarmerProduct(FarmerProductModel model);
    
    List<FarmerProductModel> getAllFarmerProducts();

    FarmerProductModel getFarmerProduct(Long farmerProductId);

    Boolean deleteFarmerProduct(Long farmerProductId);

    List<FarmerProductModel> getFarmerProductsByProductId(Long productId);

    List<FarmerProductModel> getFarmerProductsByProductIdAndUserId(Long productId, Long userId);

    List<FarmerProductModel> getFarmerProductsByUserId(Long userId);

    List<FarmerProductModel> getFarmerProductsByUserIdAndSoldStatus(Long userId, Boolean  sold);

    List<FarmerProductModel> getFarmerProductsByProductIdUserIdAndSoldStatus(Long productId, Long userId, Boolean sold);

}
