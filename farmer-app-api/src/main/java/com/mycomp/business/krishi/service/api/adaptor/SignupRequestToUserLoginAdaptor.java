package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.UserLogin;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;

public class SignupRequestToUserLoginAdaptor implements ModelAdaptor<SignupRequestModel, UserLogin> {
	public static final SignupRequestToUserLoginAdaptor INSTANCE = new SignupRequestToUserLoginAdaptor();

	public UserLogin toEntityMinimal(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		UserLogin entity = createEntityWithoutCopyingId(model);
		
		return entity;
	}

	public UserLogin toEntity(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		UserLogin entity = createEntityWithoutCopyingId(model);
		entity.setUserLoginId(model.getUserLoginId());
		
		return entity;
	}

	@Override
	public SignupRequestModel toServiceModel(UserLogin entity) {
		throw new UnsupportedOperationException("Does not support");
	}

	private static UserLogin createEntityWithoutCopyingId(SignupRequestModel model) {
		UserLogin entity = new UserLogin();

		entity.setUserId(model.getUserId());
		entity.setUserName(model.getUserName());
		entity.setPassword(model.getPassword());

		return entity;
	}

}
