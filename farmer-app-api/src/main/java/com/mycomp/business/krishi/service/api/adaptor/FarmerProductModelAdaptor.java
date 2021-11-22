package com.mycomp.business.krishi.service.api.adaptor;

import java.util.Date;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.FarmerProduct;
import com.mycomp.business.krishi.service.api.model.FarmerProductModel;

public class FarmerProductModelAdaptor implements ModelAdaptor<FarmerProductModel, FarmerProduct> {
	public static final FarmerProductModelAdaptor INSTANCE = new FarmerProductModelAdaptor();

	public FarmerProductModelAdaptor() {
	}

	public FarmerProduct toEntityMinimal(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		return createEntityWithouCopyingId(model);
	}

	public FarmerProduct toEntity(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		FarmerProduct entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductId(model.getFarmerProductId());

		return entity;
	}

	public FarmerProductModel toServiceModel(FarmerProduct entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductModel model = new FarmerProductModel();

		model.setFarmerProductId(entity.getFarmerProductId());
		model.setProductId(entity.getProductId());
		model.setUserId(entity.getUserId());
		model.setProductQuantity(entity.getProductQuantity());
		model.setExpectedPrice(entity.getExpectedPrice());
		model.setAddedOn(entity.getAddedOn());
		model.setSold(entity.isSold());
		model.setSoldOn(entity.getSoldOn());

		return model;
	}

	private static FarmerProduct createEntityWithouCopyingId(FarmerProductModel model) {
		FarmerProduct entity = new FarmerProduct();

		entity.setProductId(model.getProductId());
		entity.setUserId(model.getUserId());
		entity.setProductQuantity(model.getProductQuantity());
		entity.setExpectedPrice(model.getExpectedPrice());
		entity.setAddedOn(new java.sql.Timestamp(new Date().getTime()));
		entity.setSold(false);

		return entity;
	}

}
