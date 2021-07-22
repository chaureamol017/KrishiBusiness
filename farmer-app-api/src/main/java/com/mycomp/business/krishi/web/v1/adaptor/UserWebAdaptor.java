package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.UserModel;
import com.mycomp.business.krishi.web.v1.model.UserWeb;

public class UserWebAdaptor {

	public static UserModel toServiceModel(UserWeb web) {
		if (null == web) {
			return null;
		}
		UserModel model = createServiceModel(web);
		return model;
	}

	public static List<UserWeb> toWebModel(List<UserModel> models) {
		List<UserWeb> webModels = models.stream().map(model -> createWebModel(model))
				.collect(Collectors.toList());
		return webModels;
	}

	public static UserWeb toWebModel(UserModel model) {
		if (null == model) {
			return null;
		}
		UserWeb web = createWebModel(model);
		return web;
	}

	private static UserModel createServiceModel(UserWeb web) {
		UserModel model = new UserModel();

		model.setUserId(web.getUserId());
		model.setFirstName(web.getFirstName());
		model.setMiddleName(web.getMiddleName());
		model.setLastName(web.getLastName());
		model.setEmailId(web.getEmailId());
		model.setMobile(web.getMobile());
		model.setRole(web.getRole());
		model.setGender(web.getGender());
		model.setMaritalStatus(web.getMaritalStatus());
		model.setBirthDate(web.getBirthDate());

		return model;
	}

	private static UserWeb createWebModel(UserModel model) {
		UserWeb web = new UserWeb();

		web.setUserId(model.getUserId());
		web.setFirstName(model.getFirstName());
		web.setMiddleName(model.getMiddleName());
		web.setLastName(model.getLastName());
		web.setEmailId(model.getEmailId());
		web.setMobile(model.getMobile());
		web.setRole(model.getRole());
		web.setGender(model.getGender());
		web.setMaritalStatus(model.getMaritalStatus());
		web.setBirthDate(model.getBirthDate());

		return web;
	}

}
