package com.mycomp.krishi.service.api;

import java.util.List;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
public interface FarmerProductBidService {

	FarmerProductBidModel save(FarmerProductBidModel model);
	FarmerProductBidModel update(FarmerProductBidModel model);
	FarmerProductBidModel getById(Long id);
	List<FarmerProductBidModel> getAll();
	Boolean deleteById(Long id);
}

