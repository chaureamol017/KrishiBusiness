package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.Date;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.FarmerProductModel;
import com.mycomp.business.krishi.web.v1.model.FarmerProductWeb;

public class FarmerProductWebAdaptor implements WebAdaptor<FarmerProductWeb, FarmerProductModel> {
	public static final FarmerProductWebAdaptor INSTANCE = new FarmerProductWebAdaptor();

	private FarmerProductWebAdaptor() {
	}

	public FarmerProductWeb toWebModel(FarmerProductModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductWeb web = new FarmerProductWeb();

		web.setFarmerProductId(model.getFarmerProductId());
		web.setProductId(model.getProductId());
		web.setUserId(model.getUserId());
		web.setProductQuantity(model.getProductQuantity());
		web.setExpectedPrice(model.getExpectedPrice());
		web.setAddedOn(new java.sql.Timestamp(new Date().getTime()));
		web.setSold(false);

		return web;
	}

	public FarmerProductModel toServiceModel(FarmerProductWeb web) {
		if (null == web) {
			return null;
		}
		FarmerProductModel model = new FarmerProductModel();

		model.setFarmerProductId(web.getFarmerProductId());
		model.setProductId(web.getProductId());
		model.setUserId(web.getUserId());
		model.setProductQuantity(web.getProductQuantity());
		model.setExpectedPrice(web.getExpectedPrice());
		model.setAddedOn(web.getAddedOn());
		model.setSold(web.isSold());
		model.setSoldOn(web.getSoldOn());

		return model;
	}
}
