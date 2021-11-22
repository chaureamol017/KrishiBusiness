package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.ProductModel;
import com.mycomp.business.krishi.web.v1.model.ProductWeb;

public class ProductWebAdaptor implements WebAdaptor<ProductWeb, ProductModel> {
	public static final ProductWebAdaptor INSTANCE = new ProductWebAdaptor();

	private ProductWebAdaptor() {
	}

	public ProductModel toServiceModel(ProductWeb web) {
		if (null == web) {
			return null;
		}
		ProductModel model = new ProductModel();

		model.setProductId(web.getProductId());
		model.setProductName(web.getProductName());
		model.setDescription(web.getDescription());
//		model.setProductCategory(web.getProductCategory().toString());

		return model;
	}

	public ProductWeb toWebModel(ProductModel model) {
		if (null == model) {
			return null;
		}
		ProductWeb web = new ProductWeb();

		web.setProductId(model.getProductId());
		web.setProductName(model.getProductName());
		web.setDescription(model.getDescription());
		web.setProductCategory(model.getProductCategory());

		return web;
	}
}
