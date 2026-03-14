package com.mycomp.krishi.service.api;

import java.util.List;
import java.util.Map;
import com.mycomp.krishi.service.model.FarmerProductModel;
public interface FarmerProductService {

	FarmerProductModel save(FarmerProductModel model);
	FarmerProductModel update(FarmerProductModel model);

	int markSold(Long farmerProductId);

	FarmerProductModel getById(Long id);
	List<FarmerProductModel> getBySeller(Long userId);
	List<FarmerProductModel> getForSeller(Long userId);
	List<FarmerProductModel> searchProducts(Long userId, Map<String, String> filters);
	Boolean deleteById(Long id);
}

