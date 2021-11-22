package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.web.v1.model.SignupRequestParams;

import java.util.List;

public class SignupRequestParamsAdaptor implements WebAdaptor<SignupRequestParams, SignupRequestModel> {
	public static final SignupRequestParamsAdaptor INSTANCE = new SignupRequestParamsAdaptor();

	private SignupRequestParamsAdaptor() {
	}

	@Override
	public List<SignupRequestModel> toServiceModel(List<SignupRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	public SignupRequestModel toServiceModel(SignupRequestParams web) {
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
	public List<SignupRequestParams> toWebModel(List<SignupRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public SignupRequestParams toWebModel(SignupRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}
}
