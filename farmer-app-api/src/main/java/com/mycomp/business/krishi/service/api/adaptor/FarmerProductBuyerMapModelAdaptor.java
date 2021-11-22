package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.FarmerProductBuyerMap;
import com.mycomp.business.krishi.service.api.model.FarmerProductBuyerMapModel;

public final class FarmerProductBuyerMapModelAdaptor implements ModelAdaptor<FarmerProductBuyerMapModel, FarmerProductBuyerMap> {
	public static final FarmerProductBuyerMapModelAdaptor INSTANCE = new FarmerProductBuyerMapModelAdaptor();

	private FarmerProductBuyerMapModelAdaptor() {
	}

	public FarmerProductBuyerMap toEntityMinimal(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		return createEntityWithouCopyingId(model);
	}

	public FarmerProductBuyerMap toEntity(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBuyerMap entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductBuyerMapId(model.getFarmerProductBuyerMapId());

		return entity;
	}

	public FarmerProductBuyerMapModel toServiceModel(FarmerProductBuyerMap entity) {
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

	private FarmerProductBuyerMap createEntityWithouCopyingId(FarmerProductBuyerMapModel model) {
		FarmerProductBuyerMap entity = new FarmerProductBuyerMap();

		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setSoldPrice(model.getSoldPrice());
		entity.setSoldOn(model.getSoldOn());

		return entity;
	}
}
