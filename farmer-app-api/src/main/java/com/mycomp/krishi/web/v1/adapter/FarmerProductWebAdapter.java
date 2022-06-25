package com.mycomp.krishi.web.v1.adapter;

import java.util.Date;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.FarmerProductModel;
import com.mycomp.krishi.web.v1.model.FarmerProductWeb;

public class FarmerProductWebAdapter implements WebAdapter<FarmerProductWeb, FarmerProductModel> {
	public static final FarmerProductWebAdapter INSTANCE = new FarmerProductWebAdapter();

	private FarmerProductWebAdapter() {
	}

	public FarmerProductWeb toWeb(FarmerProductModel model) {
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

	public FarmerProductModel toModel(FarmerProductWeb web) {
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
