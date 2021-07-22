package com.mycomp.business.krishi.service.api.adaptor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.FarmerProduct;
import com.mycomp.business.krishi.service.api.model.FarmerProductModel;

public class FarmerProductModelAdaptor {

	public static List<FarmerProduct> toEntityMinimal(List<FarmerProductModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProduct> entities = models.stream().map(model -> createEntityWithouCopyingId(model))
				.collect(Collectors.toList());
		return entities;
	}

	public static FarmerProduct toEntityMinimal(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		FarmerProduct entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static FarmerProduct toEntity(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		FarmerProduct entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductId(model.getFarmerProductId());

		return entity;
	}

	public static List<FarmerProductModel> toServiceModel(List<FarmerProduct> entities) {
		List<FarmerProductModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductModel toServiceModel(FarmerProduct entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductModel model = createServiceModel(entity);
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

	private static FarmerProductModel createServiceModel(FarmerProduct entity) {
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
