package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.ProductPriceHistoryModel;
import com.mycomp.krishi.web.v1.model.ProductPriceHistoryWeb;

public class ProductPriceHistoryWebAdapter implements WebAdapter<ProductPriceHistoryWeb, ProductPriceHistoryModel> {
	public static final ProductPriceHistoryWebAdapter INSTANCE = new ProductPriceHistoryWebAdapter();

	private ProductPriceHistoryWebAdapter() {
	}

	public ProductPriceHistoryModel toModel(ProductPriceHistoryWeb web) {
		if (null == web) {
			return null;
		}
		ProductPriceHistoryModel model = new ProductPriceHistoryModel();

		model.setProductPriceHistoryId(web.getProductPriceHistoryId());
		model.setProductId(web.getProductId());
		model.setMinimumPrice(web.getMinimumPrice());
		model.setMaximumPrice(web.getMaximumPrice());
		model.setPriceOn(web.getPriceOn());

		return model;
	}

	public ProductPriceHistoryWeb toWeb(ProductPriceHistoryModel model) {
		if (null == model) {
			return null;
		}

		ProductPriceHistoryWeb web = new ProductPriceHistoryWeb();

		web.setProductPriceHistoryId(model.getProductPriceHistoryId());
		web.setProductId(model.getProductId());
		web.setMinimumPrice(model.getMinimumPrice());
		web.setMaximumPrice(model.getMaximumPrice());
		web.setPriceOn(model.getPriceOn());

		return web;
	}
}
