package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserBankDetailsWeb;

public class UserBankDetailsWebAdaptor {

	public static List<UserBankDetailsModel> toServiceModel(List<UserBankDetailsWeb> webModels) {
		if (null == webModels) {
			return null;
		}
		List<UserBankDetailsModel> models = webModels.stream().map(model -> createServiceModel(model))
				.collect(Collectors.toList());

		return models;
	}

	public static UserBankDetailsModel toServiceModel(UserBankDetailsWeb web) {
		if (null == web) {
			return null;
		}
		UserBankDetailsModel model = createServiceModel(web);

		return model;
	}

	public static List<UserBankDetailsWeb> toWebModel(List<UserBankDetailsModel> models) {
		if (null == models) {
			return null;
		}
		List<UserBankDetailsWeb> webModels = models.stream().map(bankDetailsModel -> createWebModel(bankDetailsModel))
				.collect(Collectors.toList());

		return webModels;
	}

	public static UserBankDetailsWeb toWebModel(UserBankDetailsModel model) {
		if (null == model) {
			return null;
		}
		UserBankDetailsWeb web = createWebModel(model);

		return web;
	}

	private static UserBankDetailsModel createServiceModel(UserBankDetailsWeb web) {
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

	private static UserBankDetailsWeb createWebModel(UserBankDetailsModel model) {
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
