package com.mycomp.business.krishi.service.api.adaptor;

import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.User;
import com.mycomp.business.krishi.entity.type.Gender;
import com.mycomp.business.krishi.entity.type.MaritalStatus;
import com.mycomp.business.krishi.entity.type.UserRole;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;

public final class SignupRequestToUserAdaptor implements ModelAdaptor<SignupRequestModel, User> {
	public static final SignupRequestToUserAdaptor INSTANCE = new SignupRequestToUserAdaptor();

	private SignupRequestToUserAdaptor() {
	}

	public User toEntityMinimal(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		User entity = createEntityWithoutCopyingId(model);
		
		return entity;
	}

	public User toEntity(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		User entity = createEntityWithoutCopyingId(model);
		entity.setUserId(model.getUserId());
		
		return entity;
	}

	@Override
	public SignupRequestModel toServiceModel(User entity) {
		throw new UnsupportedOperationException("Does not support");
	}

	private User createEntityWithoutCopyingId(SignupRequestModel model) {
		User entity = new User();

		entity.setFirstName(model.getFirstName());
		entity.setMiddleName(model.getMiddleName());
		entity.setLastName(model.getLastName());
		entity.setEmailId(model.getEmailId());
		entity.setMobile(model.getMobile());
		entity.setRole(UserRole.valueOf(model.getRole()));
		entity.setGender(Gender.get(model.getGender()));
		entity.setMaritalStatus(MaritalStatus.get(model.getMaritalStatus()));
		entity.setBirthDate(model.getBirthDate());

		return entity;
	}

}
