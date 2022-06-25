package com.mycomp.krishi.service.adapter;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.persistence.entity.UserAddressDetails;
import com.mycomp.krishi.service.model.UserAddressDetailsModel;

public class UserAddressDetailsAdapter implements ModelAdapter<UserAddressDetailsModel, UserAddressDetails> {
	public static final UserAddressDetailsAdapter INSTANCE = new UserAddressDetailsAdapter();

	private UserAddressDetailsAdapter() {
	}

	public UserAddressDetails toEntityMinimal(UserAddressDetailsModel model) {
		if (null == model) {
			return null;
		}

		UserAddressDetails entity = new UserAddressDetails();
		entity.setHomeNumber(model.getHomeNumber());
		entity.setAddressLine1(model.getAddressLine1());
		entity.setAddressLine2(model.getAddressLine2());
		entity.setLocality(model.getLocality());
		entity.setCity(model.getCity());
		entity.setSubDistrict(model.getSubDistrict());
		entity.setDistrict(model.getDistrict());
		entity.setState(model.getState());
		entity.setCountry(model.getCountry());
		entity.setPincode(model.getPincode());
		entity.setEmailId(model.getEmailId());
		entity.setAlternateEmailId(model.getAlternateEmailId());
		entity.setMobileNumber(model.getMobileNumber());
		entity.setAlternateMobileNumber(model.getAlternateMobileNumber());

		return entity;
	}

	public UserAddressDetails toEntity(UserAddressDetailsModel model) {
		if (null == model) {
			return null;
		}

		UserAddressDetails entity = toEntityMinimal(model);
		entity.setUserAddressDetailsId(model.getUserAddressDetailsId());

		return entity;
	}

	public UserAddressDetailsModel toModel(UserAddressDetails addressEntity) {
		if (null == addressEntity) {
			return null;
		}
		UserAddressDetailsModel addressModel = new UserAddressDetailsModel();

		addressModel.setUserAddressDetailsId(addressEntity.getUserAddressDetailsId());
		addressModel.setHomeNumber(addressEntity.getHomeNumber());
		addressModel.setAddressLine1(addressEntity.getAddressLine1());
		addressModel.setAddressLine2(addressEntity.getAddressLine2());
		addressModel.setLocality(addressEntity.getLocality());
		addressModel.setCity(addressEntity.getCity());
		addressModel.setSubDistrict(addressEntity.getSubDistrict());
		addressModel.setDistrict(addressEntity.getDistrict());
		addressModel.setState(addressEntity.getState());
		addressModel.setCountry(addressEntity.getCountry());
		addressModel.setPincode(addressEntity.getPincode());
		addressModel.setEmailId(addressEntity.getEmailId());
		addressModel.setAlternateEmailId(addressEntity.getAlternateEmailId());
		addressModel.setMobileNumber(addressEntity.getMobileNumber());
		addressModel.setAlternateMobileNumber(addressEntity.getAlternateMobileNumber());

		return addressModel;
	}

}
