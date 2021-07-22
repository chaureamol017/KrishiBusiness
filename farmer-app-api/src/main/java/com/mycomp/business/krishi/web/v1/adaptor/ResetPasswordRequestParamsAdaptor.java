package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.service.api.model.ResetPasswordRequestModel;
import com.mycomp.business.krishi.web.v1.model.ResetPasswordRequestParams;

public class ResetPasswordRequestParamsAdaptor {

	public static ResetPasswordRequestModel toServiceModel(ResetPasswordRequestParams web) {
		if (null == web) {
			return null;
		}
		ResetPasswordRequestModel model = createServiceModel(web);

		return model;
	}

	private static ResetPasswordRequestModel createServiceModel(ResetPasswordRequestParams web) {
		ResetPasswordRequestModel model = new ResetPasswordRequestModel();

		model.setUserName(web.getUserName());
		model.setNewPassword(web.getNewPassword());

		return model;
	}
}
