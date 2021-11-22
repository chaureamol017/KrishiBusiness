package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.FarmerProductBuyerMapModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductBuyerMapWeb;

public final class FarmerProductBuyerMapWebAdaptor implements WebAdaptor<FarmerProductBuyerMapWeb, FarmerProductBuyerMapModel> {
	public static final FarmerProductBuyerMapWebAdaptor INSTANCE = new FarmerProductBuyerMapWebAdaptor();

	private FarmerProductBuyerMapWebAdaptor() {
	}

	public FarmerProductBuyerMapWeb toWebModel(FarmerProductBuyerMapModel model) {
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

	public FarmerProductBuyerMapModel toServiceModel(FarmerProductBuyerMapWeb web) {
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
