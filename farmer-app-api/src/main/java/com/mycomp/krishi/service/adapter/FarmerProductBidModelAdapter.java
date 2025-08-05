package com.mycomp.krishi.service.adapter;

import com.mycomp.krishi.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.service.model.FarmerProductBidModel;
public class FarmerProductBidModelAdapter implements ModelAdapter<FarmerProductBidModel, FarmerProductBid> {

public static final FarmerProductBidModelAdapter INSTANCE = new FarmerProductBidModelAdapter();

	private FarmerProductBidModelAdapter() {
	}
	public FarmerProductBid toEntityMinimal(final FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}

		final FarmerProductBid entity = new FarmerProductBid();

		entity.setFarmerProductBidId(model.getFarmerProductBidId());
		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setQuotedPricePerUnit(model.getQuotedPricePerUnit());
		entity.setBidOn(model.getBidOn());
		entity.setAcceptedOn(model.getAcceptedOn());
		entity.setAccepted(model.isAccepted());

		return entity;
	}

	public FarmerProductBid toEntity(final FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}

		final FarmerProductBid entity = toEntityMinimal(model);

		entity.setFarmerProductBidId(model.getFarmerProductBidId());

		return entity;
	}	public FarmerProductBidModel toModel(final FarmerProductBid entity) {
		if (null == entity) {
			return null;
		}

		final FarmerProductBidModel model = new FarmerProductBidModel();

		model.setFarmerProductBidId(entity.getFarmerProductBidId());
		model.setFarmerProductId(entity.getFarmerProductId());
		model.setBuyerUserId(entity.getBuyerUserId());
		model.setQuotedPricePerUnit(entity.getQuotedPricePerUnit());
		model.setBidOn(entity.getBidOn());
		model.setAcceptedOn(entity.getAcceptedOn());
		model.setAccepted(entity.isAccepted());

		return model;
	}
}

