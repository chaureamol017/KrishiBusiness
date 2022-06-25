package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.FarmerProductBuyerMapModel;
import com.mycomp.krishi.web.v1.model.FarmerProductBuyerMapWeb;

public final class FarmerProductBuyerMapWebAdapter implements WebAdapter<FarmerProductBuyerMapWeb, FarmerProductBuyerMapModel> {
	public static final FarmerProductBuyerMapWebAdapter INSTANCE = new FarmerProductBuyerMapWebAdapter();

	private FarmerProductBuyerMapWebAdapter() {
	}

	public FarmerProductBuyerMapWeb toWeb(FarmerProductBuyerMapModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBuyerMapWeb web = new FarmerProductBuyerMapWeb();

		web.setFarmerProductBuyerMapId(model.getFarmerProductBuyerMapId());
		web.setFarmerProductId(model.getFarmerProductId());
		web.setBuyerUserId(model.getBuyerUserId());
		web.setSoldPrice(model.getSoldPrice());
		web.setSoldOn(model.getSoldOn());

		return web;
	}

	public FarmerProductBuyerMapModel toModel(FarmerProductBuyerMapWeb web) {
		if (null == web) {
			return null;
		}
		FarmerProductBuyerMapModel model = new FarmerProductBuyerMapModel();

		model.setFarmerProductBuyerMapId(web.getFarmerProductBuyerMapId());
		model.setFarmerProductId(web.getFarmerProductId());
		model.setBuyerUserId(web.getBuyerUserId());
		model.setSoldPrice(web.getSoldPrice());
		model.setSoldOn(web.getSoldOn());

		return model;
	}

}
