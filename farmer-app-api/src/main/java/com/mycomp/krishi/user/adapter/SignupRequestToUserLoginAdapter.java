package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.UserLogin;
import com.mycomp.krishi.user.model.SignupRequestModel;

public class SignupRequestToUserLoginAdapter implements ModelAdapter<SignupRequestModel, UserLogin> {
	public static final SignupRequestToUserLoginAdapter INSTANCE = new SignupRequestToUserLoginAdapter();

	public UserLogin toEntityMinimal(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		
		UserLogin entity = new UserLogin();

		entity.setUserId(model.getUserId());
		entity.setUserName(model.getUserName());
		entity.setPassword(model.getPassword());

		return entity;
	}

	public UserLogin toEntity(SignupRequestModel model) {
		if (null == model) {
			return null;
		}

		UserLogin entity = toEntityMinimal(model);
		entity.setUserLoginId(model.getUserLoginId());
		
		return entity;
	}

	@Override
	public SignupRequestModel toModel(UserLogin entity) {
		throw new UnsupportedOperationException("Does not support");
	}

}
