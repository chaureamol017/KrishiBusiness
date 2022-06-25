package com.mycomp.krishi.web.v1.adapter;

import com.mycomp.common.adapter.WebAdapter;
import com.mycomp.krishi.service.model.UserAddressDetailsModel;
import com.mycomp.krishi.web.v1.model.UserAddressDetailsWeb;

public class UserAddressDetailsWebAdapter implements WebAdapter<UserAddressDetailsWeb, UserAddressDetailsModel> {

	public UserAddressDetailsModel toModel(UserAddressDetailsWeb addressWeb) {
		if (null == addressWeb) {
			return null;
		}
		UserAddressDetailsModel addressModel = new UserAddressDetailsModel();

		addressModel.setUserAddressDetailsId(addressWeb.getUserAddressDetailsId());
		addressModel.setHomeNumber(addressWeb.getHomeNumber());
		addressModel.setAddressLine1(addressWeb.getAddressLine1());
		addressModel.setAddressLine2(addressWeb.getAddressLine2());
		addressModel.setLocality(addressWeb.getLocality());
		addressModel.setCity(addressWeb.getCity());
		addressModel.setSubDistrict(addressWeb.getSubDistrict());
		addressModel.setDistrict(addressWeb.getDistrict());
		addressModel.setState(addressWeb.getState());
		addressModel.setCountry(addressWeb.getCountry());
		addressModel.setPincode(addressWeb.getPincode());
		addressModel.setEmailId(addressWeb.getEmailId());
		addressModel.setAlternateEmailId(addressWeb.getAlternateEmailId());
		addressModel.setMobileNumber(addressWeb.getMobileNumber());
		addressModel.setAlternateMobileNumber(addressWeb.getAlternateMobileNumber());

		return addressModel;
	}

	public UserAddressDetailsWeb toWeb(UserAddressDetailsModel addressModel) {
		if (null == addressModel) {
			return null;
		}
		UserAddressDetailsWeb addressWeb = new UserAddressDetailsWeb();

		addressWeb.setUserAddressDetailsId(addressModel.getUserAddressDetailsId());
		addressWeb.setHomeNumber(addressModel.getHomeNumber());
		addressWeb.setAddressLine1(addressModel.getAddressLine1());
		addressWeb.setAddressLine2(addressModel.getAddressLine2());
		addressWeb.setLocality(addressModel.getLocality());
		addressWeb.setCity(addressModel.getCity());
		addressWeb.setSubDistrict(addressModel.getSubDistrict());
		addressWeb.setDistrict(addressModel.getDistrict());
		addressWeb.setState(addressModel.getState());
		addressWeb.setCountry(addressModel.getCountry());
		addressWeb.setPincode(addressModel.getPincode());
		addressWeb.setEmailId(addressModel.getEmailId());
		addressWeb.setAlternateEmailId(addressModel.getAlternateEmailId());
		addressWeb.setMobileNumber(addressModel.getMobileNumber());
		addressWeb.setAlternateMobileNumber(addressModel.getAlternateMobileNumber());

		return addressWeb;
	}

}
