package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.ChangePasswordRequestModel;
import com.mycomp.business.krishi.web.v1.model.ChangePasswordRequestParams;

import java.util.List;

public final class ChangePasswordRequestParamsAdaptor implements WebAdaptor<ChangePasswordRequestParams, ChangePasswordRequestModel> {
	public static final ChangePasswordRequestParamsAdaptor INSTANCE = new ChangePasswordRequestParamsAdaptor();

	private ChangePasswordRequestParamsAdaptor() {
	}

	@Override
	public List<ChangePasswordRequestModel> toServiceModel(List<ChangePasswordRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ChangePasswordRequestModel toServiceModel(ChangePasswordRequestParams web) {
		if (null == web) {
			return null;
		}
		ChangePasswordRequestModel model = new ChangePasswordRequestModel();

		model.setUserName(web.getUserName());
		model.setOldPassword(web.getOldPassword());
		model.setNewPassword(web.getNewPassword());

		return model;
	}

	@Override
	public List<ChangePasswordRequestParams> toWebModel(List<ChangePasswordRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ChangePasswordRequestParams toWebModel(ChangePasswordRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}

}
