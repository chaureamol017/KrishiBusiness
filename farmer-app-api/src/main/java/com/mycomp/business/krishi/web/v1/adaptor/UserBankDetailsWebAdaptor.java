package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserBankDetailsWeb;

public class UserBankDetailsWebAdaptor implements WebAdaptor<UserBankDetailsWeb, UserBankDetailsModel> {
	public static final WebAdaptor<UserBankDetailsWeb, UserBankDetailsModel> INSTANCE = new UserBankDetailsWebAdaptor();

	private UserBankDetailsWebAdaptor() {
	}

	public UserBankDetailsModel toServiceModel(UserBankDetailsWeb web) {
		if (null == web) {
			return null;
		}
		UserBankDetailsModel model = new UserBankDetailsModel();

		model.setUserBankDetailsId(web.getUserBankDetailsId());
		model.setUserId(web.getUserId());
		model.setBankName(web.getBankName());
		model.setBranchName(web.getBranchName());
		model.setIfscCode(web.getIfscCode());
		model.setAccountNumber(web.getAccountNumber());
		model.setAccountType(web.getAccountType());

		return model;
	}

	public UserBankDetailsWeb toWebModel(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}
		UserBankDetailsWeb web = new UserBankDetailsWeb();

		web.setUserBankDetailsId(model.getUserBankDetailsId());
		web.setUserId(model.getUserId());
		web.setBankName(model.getBankName());
		web.setBranchName(model.getBranchName());
		web.setIfscCode(model.getIfscCode());
		web.setAccountNumber(model.getAccountNumber());
		web.setAccountType(model.getAccountType());

		return web;
	}
}
