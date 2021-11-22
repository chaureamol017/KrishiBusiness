package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.UserModel;
import com.mycomp.business.krishi.web.v1.model.UserWeb;

import java.util.List;

public class UserWebAdaptor implements WebAdaptor<UserWeb, UserModel> {
	public static final UserWebAdaptor INSTANCE = new UserWebAdaptor();

	private UserWebAdaptor() {
	}

	@Override
	public List<UserModel> toServiceModel(List<UserWeb> web) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public UserModel toServiceModel(UserWeb web) {
		if (null == web) {
			return null;
		}
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

	@Override
	public UserWeb toWebModel(UserModel model) {
		if (null == model) {
			return null;
		}
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
