package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.service.api.model.ChangePasswordRequestModel;
import com.mycomp.business.krishi.web.v1.model.ChangePasswordRequestParams;

public class ChangePasswordRequestParamsAdaptor {

	public static ChangePasswordRequestModel toServiceModel(ChangePasswordRequestParams web) {
		if (null == web) {
			return null;
		}
		ChangePasswordRequestModel model = createServiceModel(web);

		return model;
	}

	private static ChangePasswordRequestModel createServiceModel(ChangePasswordRequestParams web) {
		ChangePasswordRequestModel model = new ChangePasswordRequestModel();

		model.setUserName(web.getUserName());
		model.setOldPassword(web.getOldPassword());
		model.setNewPassword(web.getNewPassword());

		return model;
	}
}
