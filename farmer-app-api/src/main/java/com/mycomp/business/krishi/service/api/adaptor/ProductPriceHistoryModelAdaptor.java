package com.mycomp.business.krishi.service.api.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.ProductPriceHistory;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;

public class ProductPriceHistoryModelAdaptor {

	public static ProductPriceHistory toEntityMinimal(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceHistory entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static ProductPriceHistory toEntity(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceHistory entity = createEntityWithouCopyingId(model);
		entity.setProductPriceHistoryId(model.getProductPriceHistoryId());

		return entity;
	}

	public static List<ProductPriceHistoryModel> toServiceModel(List<ProductPriceHistory> entities) {
		List<ProductPriceHistoryModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static ProductPriceHistoryModel toServiceModel(ProductPriceHistory entity) {
		if (null == entity) {
			return null;
		}
		ProductPriceHistoryModel model = createServiceModel(entity);
		return model;
	}

	private static ProductPriceHistory createEntityWithouCopyingId(ProductPriceHistoryModel model) {
		ProductPriceHistory entity = new ProductPriceHistory();

		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}

	private static ProductPriceHistoryModel createServiceModel(ProductPriceHistory entity) {
		ProductPriceHistoryModel model = new ProductPriceHistoryModel();

		model.setProductPriceHistoryId(entity.getProductPriceHistoryId());
		model.setProductId(entity.getProductId());
		model.setMinimumPrice(entity.getMinimumPrice());
		model.setMaximumPrice(entity.getMaximumPrice());

		return model;
	}

}
