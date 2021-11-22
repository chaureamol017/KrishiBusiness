package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.ResetPasswordRequestModel;
import com.mycomp.business.krishi.web.v1.model.ResetPasswordRequestParams;

import java.util.List;

public class ResetPasswordRequestParamsAdaptor implements WebAdaptor<ResetPasswordRequestParams, ResetPasswordRequestModel> {
	public static final ResetPasswordRequestParamsAdaptor INSTANCE = new ResetPasswordRequestParamsAdaptor();

	private ResetPasswordRequestParamsAdaptor() {
	}

	@Override
	public List<ResetPasswordRequestModel> toServiceModel(List<ResetPasswordRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ResetPasswordRequestModel toServiceModel(ResetPasswordRequestParams web) {
		if (null == web) {
			return null;
		}
		ResetPasswordRequestModel model = new ResetPasswordRequestModel();

		model.setUserName(web.getUserName());
		model.setNewPassword(web.getNewPassword());

		return model;
	}

	@Override
	public List<ResetPasswordRequestParams> toWebModel(List<ResetPasswordRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ResetPasswordRequestParams toWebModel(ResetPasswordRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}
}
