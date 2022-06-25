package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.ProductModel;
import com.mycomp.krishi.web.v1.model.ProductWeb;

public class ProductWebAdapter implements WebAdapter<ProductWeb, ProductModel> {
	public static final ProductWebAdapter INSTANCE = new ProductWebAdapter();

	private ProductWebAdapter() {
	}

	public ProductModel toModel(ProductWeb web) {
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

	public ProductWeb toWeb(ProductModel model) {
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
