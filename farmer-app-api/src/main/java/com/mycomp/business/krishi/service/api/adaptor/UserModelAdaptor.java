package com.mycomp.business.krishi.service.api.adaptor;

import com.common.operations.CommonUtils;
import com.mycomp.business.krishi.api.adapter.ModelAdaptor;
import com.mycomp.business.krishi.entity.User;
import com.mycomp.business.krishi.entity.type.Gender;
import com.mycomp.business.krishi.entity.type.MaritalStatus;
import com.mycomp.business.krishi.entity.type.UserRole;
import com.mycomp.business.krishi.service.api.model.UserModel;

public final class UserModelAdaptor implements ModelAdaptor<UserModel, User> {
	public static final UserModelAdaptor INSTANCE = new UserModelAdaptor();

	private UserModelAdaptor() {
	}

	@Override
	public User toEntityMinimal(UserModel model) {
		if (null == model) {
			return null;
		}
		return createEntityWithoutCopyingId(model);
	}

	public User toEntity(UserModel model) {
		if (null == model) {
			return null;
		}
		User entity = createEntityWithoutCopyingId(model);
		entity.setUserId(model.getUserId());

		return entity;
	}

	public UserModel toServiceModel(User entity) {
		if (null == entity) {
			return null;
		}
		UserModel model = new UserModel();

		model.setUserId(entity.getUserId());
		model.setFirstName(entity.getFirstName());
		model.setMiddleName(entity.getMiddleName());
		model.setLastName(entity.getLastName());
		model.setEmailId(entity.getEmailId());
		model.setMobile(entity.getMobile());
		model.setRole(entity.getRole().toString());
		model.setGender(CommonUtils.getString(entity.getGender()));
		model.setMaritalStatus(CommonUtils.getString(entity.getMaritalStatus()));
		model.setBirthDate(entity.getBirthDate());

		return model;
	}

	public User updateEntity(UserModel model, User entity) {
		if (null != model.getFirstName()) {
			entity.setFirstName(model.getFirstName());
		}
		if (null != model.getMiddleName()) {
			entity.setMiddleName(model.getMiddleName());
		}
		if (null != model.getLastName()) {
			entity.setLastName(model.getLastName());
		}
		if (null != model.getEmailId()) {
			entity.setEmailId(model.getEmailId());
		}
		if (null != model.getMobile()) {
			entity.setMobile(model.getMobile());
		}
		if (null != model.getRole()) {
			entity.setRole(UserRole.valueOf(model.getRole()));
		}
		if (null != model.getGender()) {
			entity.setGender(Gender.valueOf(model.getGender()));
		}
		if (null != model.getMaritalStatus()) {
			entity.setMaritalStatus(MaritalStatus.valueOf(model.getMaritalStatus()));
		}
		if (null != model.getBirthDate()) {
			entity.setBirthDate(new java.sql.Date(model.getBirthDate().getTime()));
		}

		return entity;
	}

	private static User createEntityWithoutCopyingId(UserModel model) {
		User entity = new User();

		entity.setFirstName(model.getFirstName());
		entity.setMiddleName(model.getMiddleName());
		entity.setLastName(model.getLastName());
		entity.setEmailId(model.getEmailId());
		entity.setMobile(model.getMobile());
		entity.setRole(UserRole.valueOf(model.getRole()));
		entity.setGender(Gender.valueOf(model.getGender()));
		entity.setMaritalStatus(MaritalStatus.valueOf(model.getMaritalStatus()));
		entity.setBirthDate(new java.sql.Date(model.getBirthDate().getTime()));

		return entity;
	}

}
