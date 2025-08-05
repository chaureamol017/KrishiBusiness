package com.mycomp.krishi.service.adapter;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProduct;
import com.mycomp.krishi.service.model.FarmerProductModel;
public class FarmerProductModelAdapter implements ModelAdapter<FarmerProductModel, FarmerProduct> {

public static final FarmerProductModelAdapter INSTANCE = new FarmerProductModelAdapter();

	private FarmerProductModelAdapter() {
	}
	public FarmerProduct toEntityMinimal(final FarmerProductModel model) {
		if (null == model) {
			return null;
		}

		final FarmerProduct entity = new FarmerProduct();

		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setProductId(model.getProductId());
		entity.setUserId(model.getUserId());
		entity.setQuantity(model.getQuantity());
		entity.setQuantityUnit(model.getQuantityUnit());
		entity.setPricePerUnit(model.getPricePerUnit());
		entity.setExpectedPricePerUnit(model.getExpectedPricePerUnit());
		entity.setAddedOn(model.getAddedOn());
		entity.setSoldOn(model.getSoldOn());
		entity.setSold(model.isSold());

		return entity;
	}

	public FarmerProduct toEntity(final FarmerProductModel model) {
		if (null == model) {
			return null;
		}

		final FarmerProduct entity = toEntityMinimal(model);

		entity.setFarmerProductId(model.getFarmerProductId());

		return entity;
	}	public FarmerProductModel toModel(final FarmerProduct entity) {
		if (null == entity) {
			return null;
		}

		final FarmerProductModel model = new FarmerProductModel();

		model.setFarmerProductId(entity.getFarmerProductId());
		model.setProductId(entity.getProductId());
		model.setUserId(entity.getUserId());
		model.setQuantity(entity.getQuantity());
		model.setQuantityUnit(entity.getQuantityUnit());
		model.setPricePerUnit(entity.getPricePerUnit());
		model.setExpectedPricePerUnit(entity.getExpectedPricePerUnit());
		model.setAddedOn(entity.getAddedOn());
		model.setSoldOn(entity.getSoldOn());
		model.setSold(entity.isSold());

		return model;
	}
}

