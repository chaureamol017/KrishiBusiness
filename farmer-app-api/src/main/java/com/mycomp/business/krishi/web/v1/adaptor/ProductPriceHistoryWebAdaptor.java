package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductPriceHistoryModel;
import com.mycomp.business.krishi.web.v1.model.ProductPriceHistoryWeb;

public class ProductPriceHistoryWebAdaptor implements WebAdaptor<ProductPriceHistoryWeb, ProductPriceHistoryModel> {
	public static final ProductPriceHistoryWebAdaptor INSTANCE = new ProductPriceHistoryWebAdaptor();

	private ProductPriceHistoryWebAdaptor() {
	}

	public ProductPriceHistoryModel toServiceModel(ProductPriceHistoryWeb web) {
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

	public ProductPriceHistoryWeb toWebModel(ProductPriceHistoryModel model) {
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
