package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.model.ChangePasswordRequestModel;
import com.mycomp.krishi.user.requests.ChangePasswordRequestParams;

import java.util.List;

public final class ChangePasswordRequestParamsAdapter implements WebAdapter<ChangePasswordRequestParams, ChangePasswordRequestModel> {
	public static final ChangePasswordRequestParamsAdapter INSTANCE = new ChangePasswordRequestParamsAdapter();

	private ChangePasswordRequestParamsAdapter() {
	}

	@Override
	public List<ChangePasswordRequestModel> toModel(List<ChangePasswordRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ChangePasswordRequestModel toModel(ChangePasswordRequestParams web) {
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
	public List<ChangePasswordRequestParams> toWeb(List<ChangePasswordRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ChangePasswordRequestParams toWeb(ChangePasswordRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}

}
