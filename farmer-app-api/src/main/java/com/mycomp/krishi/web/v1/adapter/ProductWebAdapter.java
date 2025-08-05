package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.ProductModel;
import com.mycomp.krishi.web.v1.model.ProductRequest;
import com.mycomp.krishi.web.v1.model.ProductResponse;

public class ProductWebAdapter implements WebAdapter<ProductRequest, ProductResponse, ProductModel> {

	public static final ProductWebAdapter INSTANCE = new ProductWebAdapter();

	private ProductWebAdapter() {
	}
	public ProductResponse toWeb(final ProductModel model) {
		if (null == model) {
			return null;
		}
		final ProductResponse web = new ProductResponse();

		web.setProductId(model.getProductId());
		web.setName(model.getName());
		web.setDescription(model.getDescription());
		web.setCategory(model.getCategory());

		return web;
	}
	public ProductModel toModel(final ProductRequest web) {
		if (null == web) {
			return null;
		}
		final ProductModel model = new ProductModel();

		model.setProductId(web.getProductId());
		model.setName(web.getName());
		model.setDescription(web.getDescription());
		model.setCategory(web.getCategory());

		return model;
	}
}

