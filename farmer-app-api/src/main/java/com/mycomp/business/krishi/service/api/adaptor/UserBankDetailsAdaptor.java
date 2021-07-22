package com.mycomp.business.krishi.service.api.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.UserBankDetails;
import com.mycomp.business.krishi.entity.type.AccountType;
import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;

public class UserBankDetailsAdaptor {

	public static List<UserBankDetails> toEntityMinimal(List<UserBankDetailsModel> models) {
		if (null == models) {
			return null;
		}
		List<UserBankDetails> entities = models.stream()
				.map(bankDetailsModel -> createEntityWithoutCopyingId(bankDetailsModel)).collect(Collectors.toList());

		return entities;
	}

	public static UserBankDetails toEntityMinimal(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}
		UserBankDetails entity = createEntityWithoutCopyingId(model);

		return entity;
	}

	public static UserBankDetails toEntity(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}
		UserBankDetails entity = createEntityWithoutCopyingId(model);
		entity.setUserBankDetailsId(model.getUserBankDetailsId());

		return entity;
	}

	public static List<UserBankDetailsModel> toServiceModel(List<UserBankDetails> entities) {
		if (null == entities) {
			return null;
		}
		List<UserBankDetailsModel> models = entities.stream().map(entity -> createServiceModel(entity))
				.collect(Collectors.toList());

		return models;
	}

	public static UserBankDetailsModel toServiceModel(UserBankDetails entity) {
		if (null == entity) {
			return null;
		}
		UserBankDetailsModel model = createServiceModel(entity);

		return model;
	}

	private static UserBankDetails createEntityWithoutCopyingId(UserBankDetailsModel model) {
		AccountType accountType = (null != model.getAccountType()
				&& null != AccountType.valueOf(model.getAccountType())) ? AccountType.valueOf(model.getAccountType())
						: AccountType.SAVING;

		UserBankDetails entity = new UserBankDetails();
		entity.setUserId(model.getUserId());
		entity.setBankName(model.getBankName());
		entity.setBranchName(model.getBranchName());
		entity.setIfscCode(model.getIfscCode());
		entity.setAccountNumber(model.getAccountNumber());
		entity.setAccountType(accountType);

		return entity;
	}

	private static UserBankDetailsModel createServiceModel(UserBankDetails entity) {
		AccountType accountType = (null != entity.getAccountType()) ? entity.getAccountType() : AccountType.SAVING;

		UserBankDetailsModel model = new UserBankDetailsModel();
		model.setUserBankDetailsId(model.getUserBankDetailsId());
		model.setUserId(entity.getUserId());
		model.setBankName(entity.getBankName());
		model.setBranchName(entity.getBranchName());
		model.setIfscCode(entity.getIfscCode());
		model.setAccountNumber(entity.getAccountNumber());
		model.setAccountType(accountType.toString());

		return model;
	}
}
