package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.UserBankDetails;
import com.mycomp.krishi.persistence.entity.type.AccountType;
import com.mycomp.krishi.service.model.UserBankDetailsModel;

public class UserBankDetailsAdapter implements ModelAdapter<UserBankDetailsModel, UserBankDetails> {
	public static final UserBankDetailsAdapter INSTANCE = new UserBankDetailsAdapter();

	private UserBankDetailsAdapter() {
	}

	public UserBankDetails toEntityMinimal(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}

		AccountType accountType = (null != model.getAccountType() && null != AccountType.valueOf(model.getAccountType()))
				? AccountType.valueOf(model.getAccountType())
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

	public UserBankDetails toEntity(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}

		UserBankDetails entity = toEntityMinimal(model);
		entity.setUserBankDetailsId(model.getUserBankDetailsId());

		return entity;
	}

	public UserBankDetailsModel toModel(UserBankDetails entity) {
		if (null == entity) {
			return null;
		}

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
