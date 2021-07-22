package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.entity.UserLogin;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;

public class SignupRequestToUserLoginAdaptor {

	public static UserLogin toEntityMinimal(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		UserLogin entity = createEntityWithoutCopyingId(model);
		
		return entity;
	}

	public static UserLogin toEntity(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		UserLogin entity = createEntityWithoutCopyingId(model);
		entity.setUserLoginId(model.getUserLoginId());
		
		return entity;
	}

	private static UserLogin createEntityWithoutCopyingId(SignupRequestModel model) {
		UserLogin entity = new UserLogin();

		entity.setUserId(model.getUserId());
		entity.setUserName(model.getUserName());
		entity.setPassword(model.getPassword());

		return entity;
	}

}
