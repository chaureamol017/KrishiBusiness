package com.mycomp.krishi.user.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.user.model.ResetPasswordRequestModel;
import com.mycomp.krishi.user.requests.ResetPasswordRequestParams;

import java.util.List;

public class ResetPasswordRequestParamsAdapter implements WebAdapter<ResetPasswordRequestParams, ResetPasswordRequestModel> {
	public static final ResetPasswordRequestParamsAdapter INSTANCE = new ResetPasswordRequestParamsAdapter();

	private ResetPasswordRequestParamsAdapter() {
	}

	@Override
	public List<ResetPasswordRequestModel> toModel(List<ResetPasswordRequestParams> requests) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ResetPasswordRequestModel toModel(ResetPasswordRequestParams web) {
		if (null == web) {
			return null;
		}

		ResetPasswordRequestModel model = new ResetPasswordRequestModel();
		model.setUserName(web.getUserName());
		model.setNewPassword(web.getNewPassword());

		return model;
	}

	@Override
	public List<ResetPasswordRequestParams> toWeb(List<ResetPasswordRequestModel> models) {
		throw new UnsupportedOperationException("Does not support");
	}

	@Override
	public ResetPasswordRequestParams toWeb(ResetPasswordRequestModel entity) {
		throw new UnsupportedOperationException("Does not support");
	}
}
