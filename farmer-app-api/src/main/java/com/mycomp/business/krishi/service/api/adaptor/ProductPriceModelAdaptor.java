package com.mycomp.business.krishi.service.api.adaptor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.ProductPrice;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.service.api.model.ProductPriceModel;

public class ProductPriceModelAdaptor {

	public static ProductPrice toEntityMinimal(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPrice entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static ProductPrice toEntity(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPrice entity = createEntityWithouCopyingId(model);
		entity.setProductPriceId(model.getProductPriceId());

		return entity;
	}

	public static ProductPriceHistoryModel toHistoryServiceModel(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceHistoryModel historyModel = createHistoryServiceModel(model);
		return historyModel;
	}

	public static List<ProductPriceModel> toServiceModel(List<ProductPrice> entities) {
		List<ProductPriceModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductPriceModel toServiceModel(ProductPrice entity) {
		if (null == entity) {
			return null;
		}
		ProductPriceModel model = createServiceModel(entity);
		return model;
	}

	private static ProductPrice createEntityWithouCopyingId(ProductPriceModel model) {
		ProductPrice entity = new ProductPrice();

		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}

	private static ProductPriceModel createServiceModel(ProductPrice entity) {
		ProductPriceModel model = new ProductPriceModel();

		model.setProductPriceId(entity.getProductPriceId());
		model.setProductId(entity.getProductId());
		model.setMinimumPrice(entity.getMinimumPrice());
		model.setMaximumPrice(entity.getMaximumPrice());

		return model;
	}

	private static ProductPriceHistoryModel createHistoryServiceModel(ProductPriceModel model) {
		ProductPriceHistoryModel historyModel = new ProductPriceHistoryModel();

		historyModel.setProductId(model.getProductId());
		historyModel.setMinimumPrice(model.getMinimumPrice());
		historyModel.setMaximumPrice(model.getMaximumPrice());
		historyModel.setPriceOn(new Date());

		return historyModel;
	}

}
