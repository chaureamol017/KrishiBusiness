package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProductBuyerMap;
import com.mycomp.krishi.service.model.FarmerProductBuyerMapModel;

public final class FarmerProductBuyerMapModelAdapter implements ModelAdapter<FarmerProductBuyerMapModel, FarmerProductBuyerMap> {
	public static final FarmerProductBuyerMapModelAdapter INSTANCE = new FarmerProductBuyerMapModelAdapter();

	private FarmerProductBuyerMapModelAdapter() {
	}

	public FarmerProductBuyerMap toEntityMinimal(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}

		FarmerProductBuyerMap entity = new FarmerProductBuyerMap();
		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setSoldPrice(model.getSoldPrice());
		entity.setSoldOn(model.getSoldOn());

		return entity;
	}

	public FarmerProductBuyerMap toEntity(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}

		FarmerProductBuyerMap entity = toEntityMinimal(model);
		entity.setFarmerProductBuyerMapId(model.getFarmerProductBuyerMapId());

		return entity;
	}

	public FarmerProductBuyerMapModel toModel(FarmerProductBuyerMap entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductBuyerMapModel model = new FarmerProductBuyerMapModel();

		model.setFarmerProductBuyerMapId(entity.getFarmerProductBuyerMapId());
		model.setFarmerProductId(entity.getFarmerProductId());
		model.setBuyerUserId(entity.getBuyerUserId());
		model.setSoldPrice(entity.getSoldPrice());
		model.setSoldOn(entity.getSoldOn());

		return model;
	}

}
