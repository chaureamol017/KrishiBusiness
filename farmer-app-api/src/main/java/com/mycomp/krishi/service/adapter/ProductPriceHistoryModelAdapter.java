package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.ProductPriceHistory;
import com.mycomp.krishi.service.model.ProductPriceHistoryModel;

public final class ProductPriceHistoryModelAdapter implements ModelAdapter<ProductPriceHistoryModel, ProductPriceHistory> {
	public static ProductPriceHistoryModelAdapter INSTANCE = new ProductPriceHistoryModelAdapter();

	private ProductPriceHistoryModelAdapter() {
	}

	@Override
	public ProductPriceHistory toEntityMinimal(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}
		
		ProductPriceHistory entity = new ProductPriceHistory();
		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}

	public ProductPriceHistory toEntity(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}

		ProductPriceHistory entity = toEntityMinimal(model);
		entity.setProductPriceHistoryId(model.getProductPriceHistoryId());

		return entity;
	}

	public ProductPriceHistoryModel toModel(ProductPriceHistory entity) {
		if (null == entity) {
			return null;
		}
		ProductPriceHistoryModel model = new ProductPriceHistoryModel();

		model.setProductPriceHistoryId(entity.getProductPriceHistoryId());
		model.setProductId(entity.getProductId());
		model.setMinimumPrice(entity.getMinimumPrice());
		model.setMaximumPrice(entity.getMaximumPrice());

		return model;
	}

}
