package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.User;
import com.mycomp.krishi.persistence.entity.type.Gender;
import com.mycomp.krishi.persistence.entity.type.MaritalStatus;
import com.mycomp.krishi.persistence.entity.type.UserRole;
import com.mycomp.krishi.user.model.SignupRequestModel;

public final class SignupRequestToUserAdapter implements ModelAdapter<SignupRequestModel, User> {
	public static final SignupRequestToUserAdapter INSTANCE = new SignupRequestToUserAdapter();

	private SignupRequestToUserAdapter() {
	}

	public User toEntityMinimal(SignupRequestModel model) {
		if (null == model) {
			return null;
		}
		
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

	public User toEntity(SignupRequestModel model) {
		if (null == model) {
			return null;
		}

		User entity = toEntityMinimal(model);
		entity.setUserId(model.getUserId());
		
		return entity;
	}

	@Override
	public SignupRequestModel toModel(User entity) {
		throw new UnsupportedOperationException("Does not support");
	}

}
