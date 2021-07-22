package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.service.api.model.SignupRequestModel;
import com.mycomp.business.krishi.web.v1.model.SignupRequestParams;

public class SignupRequestParamsAdaptor {

	public static SignupRequestModel toServiceModel(SignupRequestParams web) {
		if (null == web) {
			return null;
		}
		SignupRequestModel model = createServiceModel(web);

		return model;
	}

	private static SignupRequestModel createServiceModel(SignupRequestParams web) {
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
}
