package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.krishi.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.FarmerProductModel;
import com.mycomp.krishi.web.v1.model.FarmerProductRequest;
import com.mycomp.krishi.web.v1.model.FarmerProductResponse;

public class FarmerProductWebAdapter implements WebAdapter<FarmerProductRequest, FarmerProductResponse, FarmerProductModel> {

	public static final FarmerProductWebAdapter INSTANCE = new FarmerProductWebAdapter();

	private FarmerProductWebAdapter() {
	}
	public FarmerProductResponse toWeb(final FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		final FarmerProductResponse web = new FarmerProductResponse();

		web.setFarmerProductId(model.getFarmerProductId());
		web.setProductId(model.getProductId());
		web.setUserId(model.getUserId());
		web.setQuantity(model.getQuantity());
		web.setQuantityUnit(model.getQuantityUnit());
		web.setPricePerUnit(model.getPricePerUnit());
		web.setExpectedPricePerUnit(model.getExpectedPricePerUnit());
		web.setAddedOn(model.getAddedOn());
		web.setSoldOn(model.getSoldOn());
		web.setSold(model.isSold());

		return web;
	}
	public FarmerProductModel toModel(final FarmerProductRequest web) {
		if (null == web) {
			return null;
		}
		final FarmerProductModel model = new FarmerProductModel();

		model.setFarmerProductId(web.getFarmerProductId());
		model.setProductId(web.getProductId());
		model.setUserId(web.getUserId());
		model.setQuantity(web.getQuantity());
		model.setQuantityUnit(web.getQuantityUnit());
		model.setPricePerUnit(web.getPricePerUnit());
		model.setExpectedPricePerUnit(web.getExpectedPricePerUnit());
		model.setAddedOn(web.getAddedOn());
		model.setSoldOn(web.getSoldOn());
		model.setSold(web.isSold());

		return model;
	}
}

