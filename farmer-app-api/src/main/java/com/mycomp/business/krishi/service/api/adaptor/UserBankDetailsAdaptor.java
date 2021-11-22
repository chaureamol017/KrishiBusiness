package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.UserBankDetails;
import com.mycomp.business.krishi.entity.type.AccountType;
import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;

public class UserBankDetailsAdaptor implements ModelAdaptor<UserBankDetailsModel, UserBankDetails> {
	public static final UserBankDetailsAdaptor INSTANCE = new UserBankDetailsAdaptor();

	private UserBankDetailsAdaptor() {
	}

	public UserBankDetails toEntityMinimal(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}

		return createEntityWithoutCopyingId(model);
	}

	public UserBankDetails toEntity(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}
		UserBankDetails entity = createEntityWithoutCopyingId(model);
		entity.setUserBankDetailsId(model.getUserBankDetailsId());

		return entity;
	}

	public UserBankDetailsModel toServiceModel(UserBankDetails entity) {
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

}
