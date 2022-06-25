package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.UserBankDetailsModel;
import com.mycomp.krishi.web.v1.model.UserBankDetailsWeb;

public class UserBankDetailsWebAdapter implements WebAdapter<UserBankDetailsWeb, UserBankDetailsModel> {
	public static final WebAdapter<UserBankDetailsWeb, UserBankDetailsModel> INSTANCE = new UserBankDetailsWebAdapter();

	private UserBankDetailsWebAdapter() {
	}

	public UserBankDetailsModel toModel(UserBankDetailsWeb web) {
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

	public UserBankDetailsWeb toWeb(UserBankDetailsModel model) {
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
