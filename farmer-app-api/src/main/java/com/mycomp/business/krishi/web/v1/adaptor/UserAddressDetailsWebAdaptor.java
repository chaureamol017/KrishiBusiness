package com.mycomp.business.krishi.web.v1.adaptor;

import com.mycomp.business.krishi.api.adapter.WebAdaptor;
import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserAddressDetailsWeb;

public class UserAddressDetailsWebAdaptor implements WebAdaptor<UserAddressDetailsWeb, UserAddressDetailsModel> {

	public UserAddressDetailsModel toServiceModel(UserAddressDetailsWeb addressWeb) {
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

	public UserAddressDetailsWeb toWebModel(UserAddressDetailsModel addressModel) {
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
