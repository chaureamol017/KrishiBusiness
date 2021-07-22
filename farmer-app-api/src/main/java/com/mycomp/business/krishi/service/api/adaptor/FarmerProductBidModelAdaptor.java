package com.mycomp.business.krishi.service.api.adaptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.FarmerProductBid;
import com.mycomp.business.krishi.service.api.model.FarmerProductBidModel;

public class FarmerProductBidModelAdaptor {


	public static List<FarmerProductBid> toEntityMinimal(List<FarmerProductBidModel> models) {
		if (null == models) {
			return null;
		}
		List<FarmerProductBid> entities = models.stream().map(model -> createEntityWithouCopyingId(model))
				.collect(Collectors.toList());
		return entities;
	}

	public static FarmerProductBid toEntityMinimal(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBid entity = createEntityWithouCopyingId(model);
		return entity;
	}

	public static FarmerProductBid toEntity(FarmerProductBidModel model) {
		if (null == model) {
			return null;
		}
		FarmerProductBid entity = createEntityWithouCopyingId(model);
		entity.setFarmerProductBidId(model.getFarmerProductBidId());

		return entity;
	}

	public static List<FarmerProductBidModel> toServiceModel(List<FarmerProductBid> entities) {
		List<FarmerProductBidModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static FarmerProductBidModel toServiceModel(FarmerProductBid entity) {
		if (null == entity) {
			return null;
		}
		FarmerProductBidModel model = createServiceModel(entity);
		return model;
	}
	
	public static FarmerProductBid acceptBid(FarmerProductBid entity) {
		Timestamp acceptedOn = new Timestamp(new Date().getTime());

		entity.setAccepted(true);
		entity.setAcceptedOn(acceptedOn);
		
		return entity;
	}

	private static FarmerProductBid createEntityWithouCopyingId(FarmerProductBidModel model) {
		FarmerProductBid entity = new FarmerProductBid();

		entity.setFarmerProductId(model.getFarmerProductId());
		entity.setBuyerUserId(model.getBuyerUserId());
		entity.setBiddingRate(model.getBiddingRate());
		entity.setBidOn(model.getBidOn());
		entity.setAccepted(model.isAccepted());
		entity.setAcceptedOn(model.getAcceptedOn());
		return entity;
	}

	private static FarmerProductBidModel createServiceModel(FarmerProductBid entity) {
		FarmerProductBidModel model = new FarmerProductBidModel();

		model.setFarmerProductBidId(entity.getFarmerProductBidId());
		model.setFarmerProductId(entity.getFarmerProductId());
		model.setBuyerUserId(entity.getBuyerUserId());
		model.setBiddingRate(entity.getBiddingRate());
		model.setBidOn(entity.getBidOn());
		model.setAccepted(entity.isAccepted());
		model.setAcceptedOn(entity.getAcceptedOn());

		return model;
	}
}
