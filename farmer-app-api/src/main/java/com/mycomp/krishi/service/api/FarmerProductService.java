package com.mycomp.krishi.service.api;

import java.util.List;
import com.mycomp.krishi.service.model.FarmerProductModel;
public interface FarmerProductService {

	FarmerProductModel save(FarmerProductModel model);
	FarmerProductModel update(FarmerProductModel model);

	int markSold(Long farmerProductId);

	FarmerProductModel getById(Long id);
	List<FarmerProductModel> getBySeller(Long userId);
	List<FarmerProductModel> getForSeller(Long userId);
	List<FarmerProductModel> searchProducts(Long userId, String category, String city, String search);
	Boolean deleteById(Long id);
}

