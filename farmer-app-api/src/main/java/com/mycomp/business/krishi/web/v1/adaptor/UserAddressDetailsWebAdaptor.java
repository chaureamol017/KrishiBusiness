package com.mycomp.business.krishi.web.v1.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;
import com.mycomp.business.krishi.web.v1.model.UserAddressDetailsWeb;

public class UserAddressDetailsWebAdaptor {

	public static List<UserAddressDetailsModel> toServiceModel(List<UserAddressDetailsWeb> addressWebModels) {
		if (null == addressWebModels) {
			return null;
		}
		List<UserAddressDetailsModel> addressModels = addressWebModels.stream()
				.map(addressEntity -> createServiceModel(addressEntity))
				.collect(Collectors.toList());

		return addressModels;
	}

	public static UserAddressDetailsModel toServiceModel(UserAddressDetailsWeb addressWeb) {
		if (null == addressWeb) {
			return null;
		}
		UserAddressDetailsModel addressModel = createServiceModel(addressWeb);

		return addressModel;
	}

	public static List<UserAddressDetailsWeb> toWebModel(List<UserAddressDetailsModel> addressModels) {
		if (null == addressModels) {
			return null;
		}

		List<UserAddressDetailsWeb> addressWebModels = addressModels.stream()
				.map(addressModel -> createWebModel(addressModel))
				.collect(Collectors.toList());

		return addressWebModels;
	}

	public static UserAddressDetailsWeb toWebModel(UserAddressDetailsModel addressModel) {
		if (null == addressModel) {
			return null;
		}

		return createWebModel(addressModel);
	}

	private static UserAddressDetailsModel createServiceModel(UserAddressDetailsWeb addressWeb) {
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

	private static UserAddressDetailsWeb createWebModel(UserAddressDetailsModel addressModel) {
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
