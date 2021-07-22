package com.mycomp.business.krishi.service.api.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.FarmerProductBuyerMap;
import com.mycomp.business.krishi.service.api.model.FarmerProductBuyerMapModel;

public class FarmerProductBuyerMapModelAdaptor {

	public static List<FarmerProductBuyerMap> toEntityMinimal(List<FarmerProductBuyerMapModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProductBuyerMap> entities = models.stream().map(model -> createEntityWithouCopyingId(model))
				.collect(Collectors.toList());
		return entities;
	}

	public static FarmerProductBuyerMap toEntityMinimal(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBuyerMap entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static FarmerProductBuyerMap toEntity(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBuyerMap entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductBuyerMapId(model.getFarmerProductBuyerMapId());

		return entity;
	}

	public static List<FarmerProductBuyerMapModel> toServiceModel(List<FarmerProductBuyerMap> entities) {
		List<FarmerProductBuyerMapModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductBuyerMapModel toServiceModel(FarmerProductBuyerMap entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductBuyerMapModel model = createServiceModel(entity);
		return model;
	}

	private static FarmerProductBuyerMap createEntityWithouCopyingId(FarmerProductBuyerMapModel model) {
		FarmerProductBuyerMap entity = new FarmerProductBuyerMap();

		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setSoldPrice(model.getSoldPrice());
		entity.setSoldOn(model.getSoldOn());

		return entity;
	}

	private static FarmerProductBuyerMapModel createServiceModel(FarmerProductBuyerMap entity) {
		FarmerProductBuyerMapModel model = new FarmerProductBuyerMapModel();

		model.setFarmerProductBuyerMapId(entity.getFarmerProductBuyerMapId());
		model.setFarmerProductId(entity.getFarmerProductId());
		model.setBuyerUserId(entity.getBuyerUserId());
		model.setSoldPrice(entity.getSoldPrice());
		model.setSoldOn(entity.getSoldOn());

		return model;
	}
}
