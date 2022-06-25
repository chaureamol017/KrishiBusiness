package com.mycomp.krishi.service.adapter;

import java.util.Date;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.service.model.FarmerProductModel;

public class FarmerProductModelAdapter implements ModelAdapter<FarmerProductModel, FarmerProduct> {
	public static final FarmerProductModelAdapter INSTANCE = new FarmerProductModelAdapter();

	public FarmerProductModelAdapter() {
	}

	public FarmerProduct toEntityMinimal(FarmerProductModel model) {
		if (null == model) {
			return null;
		}

		FarmerProduct entity = new FarmerProduct();
		entity.setProductId(model.getProductId());
		entity.setUserId(model.getUserId());
		entity.setProductQuantity(model.getProductQuantity());
		entity.setExpectedPrice(model.getExpectedPrice());
		entity.setAddedOn(new java.sql.Timestamp(new Date().getTime()));
		entity.setSold(false);

		return entity;
	}

	public FarmerProduct toEntity(FarmerProductModel model) {
		if (null == model) {
			return null;
		}

		FarmerProduct entity = toEntityMinimal(model);
		entity.setFarmerProductId(model.getFarmerProductId());

		return entity;
	}

	public FarmerProductModel toModel(FarmerProduct entity) {
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

}
