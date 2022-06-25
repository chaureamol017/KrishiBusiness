package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.model.UserModel;
import com.mycomp.krishi.user.requests.UserWeb;

import java.util.List;

public class UserWebAdapter implements WebAdapter<UserWeb, UserModel> {
	public static final UserWebAdapter INSTANCE = new UserWebAdapter();

	private UserWebAdapter() {
	}

	@Override
	public List<UserModel> toModel(List<UserWeb> web) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public UserModel toModel(UserWeb web) {
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
	public UserWeb toWeb(UserModel model) {
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
