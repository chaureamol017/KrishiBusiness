package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.model.SignupRequestModel;
import com.mycomp.krishi.user.requests.SignupRequestParams;

import java.util.List;

public class SignupRequestParamsAdapter implements WebAdapter<SignupRequestParams, SignupRequestModel> {
	public static final SignupRequestParamsAdapter INSTANCE = new SignupRequestParamsAdapter();

	private SignupRequestParamsAdapter() {
	}

	@Override
	public List<SignupRequestModel> toModel(List<SignupRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	public SignupRequestModel toModel(SignupRequestParams web) {
		if (null == web) {
			return null;
		}
		SignupRequestModel model = new SignupRequestModel();

		model.setFirstName(web.getFirstName());
		model.setMiddleName(web.getMiddleName());
		model.setLastName(web.getLastName());
		model.setEmailId(web.getEmailId());
		model.setMobile(web.getMobile());
		model.setRole(web.getRole());
		model.setGender(web.getGender());
		model.setMaritalStatus(web.getMaritalStatus());
		model.setBirthDate(web.getBirthDate());

		model.setUserName(web.getEmailId());
		model.setPassword(web.getPassword());

		return model;
	}

	@Override
	public List<SignupRequestParams> toWeb(List<SignupRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public SignupRequestParams toWeb(SignupRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}
}
