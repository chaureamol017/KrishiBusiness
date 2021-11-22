package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.ProductPriceHistory;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;

public final class ProductPriceHistoryModelAdaptor implements ModelAdaptor<ProductPriceHistoryModel, ProductPriceHistory> {
	public static ProductPriceHistoryModelAdaptor INSTANCE = new ProductPriceHistoryModelAdaptor();

	private ProductPriceHistoryModelAdaptor() {
	}

	@Override
	public ProductPriceHistory toEntityMinimal(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}
		return createEntityWithouCopyingId(model);
	}

	public ProductPriceHistory toEntity(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceHistory entity = createEntityWithouCopyingId(model);
		entity.setProductPriceHistoryId(model.getProductPriceHistoryId());

		return entity;
	}

	public ProductPriceHistoryModel toServiceModel(ProductPriceHistory entity) {
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

	private static ProductPriceHistory createEntityWithouCopyingId(ProductPriceHistoryModel model) {
		ProductPriceHistory entity = new ProductPriceHistory();

		entity.setProductId(model.getProductId());
		entity.setMinimumPrice(model.getMinimumPrice());
		entity.setMaximumPrice(model.getMaximumPrice());

		return entity;
	}
}
