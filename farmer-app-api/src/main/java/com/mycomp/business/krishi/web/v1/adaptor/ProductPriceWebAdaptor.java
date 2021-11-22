package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductPriceModel;
import com.mycomp.business.krishi.web.v1.model.ProductPriceWeb;

public class ProductPriceWebAdaptor implements WebAdaptor<ProductPriceWeb, ProductPriceModel> {
	public static final ProductPriceWebAdaptor INSTANCE = new ProductPriceWebAdaptor();

	private ProductPriceWebAdaptor() {
	}

	public ProductPriceModel toServiceModel(ProductPriceWeb web) {
		if (null == web) {
			return null;
		}
		ProductPriceModel model = new ProductPriceModel();

		model.setProductPriceId(web.getProductPriceId());
		model.setProductId(web.getProductId());
		model.setMinimumPrice(web.getMinimumPrice());
		model.setMaximumPrice(web.getMaximumPrice());

		return model;
	}

	public ProductPriceWeb toWebModel(ProductPriceModel model) {
		if (null == model) {
			return null;
		}
		ProductPriceWeb web = new ProductPriceWeb();

		web.setProductPriceId(model.getProductPriceId());
		web.setProductId(model.getProductId());
		web.setMinimumPrice(model.getMinimumPrice());
		web.setMaximumPrice(model.getMaximumPrice());

		return web;
	}
}
