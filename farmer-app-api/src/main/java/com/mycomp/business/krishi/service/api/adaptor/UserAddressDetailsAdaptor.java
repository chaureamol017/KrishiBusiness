package com.mycomp.business.krishi.service.api.adaptor;

import java.util.List;
import java.util.stream.Collectors;

import com.mycomp.business.krishi.entity.UserAddressDetails;
import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;

public class UserAddressDetailsAdaptor {

	public static List<UserAddressDetails> toEntityMinimal(List<UserAddressDetailsModel> addressModels) {
		if (null == addressModels) {
			return null;
		}
		List<UserAddressDetails> addressEntities = addressModels.stream()
				.map(addressModel -> createEntityWithoutCopyingId(addressModel))
				.collect(Collectors.toList());
		
		return addressEntities;
	}

	public static UserAddressDetails toEntityMinimal(UserAddressDetailsModel addressModel) {
		if (null == addressModel) {
			return null;
		}
		UserAddressDetails addressEntity = createEntityWithoutCopyingId(addressModel);
		
		return addressEntity;
	}

	public static UserAddressDetails toEntity(UserAddressDetailsModel addressModel) {
		if (null == addressModel) {
			return null;
		}
		UserAddressDetails addressEntity = createEntityWithoutCopyingId(addressModel);
		addressEntity.setUserAddressDetailsId(addressModel.getUserAddressDetailsId());
		
		return addressEntity;
	}

	public static List<UserAddressDetailsModel> toServiceModel(List<UserAddressDetails> addressEntities) {
		if (null == addressEntities) {
			return null;
		}
		List<UserAddressDetailsModel> addressModels = addressEntities.stream()
				.map(addressEntity -> createServiceModel(addressEntity))
				.collect(Collectors.toList());
		
		return addressModels;
	}

	public static UserAddressDetailsModel toServiceModel(UserAddressDetails addressEntity) {
		if (null == addressEntity) {
			return null;
		}
		UserAddressDetailsModel addressModel = createServiceModel(addressEntity);
		
		return addressModel;
	}

	private static UserAddressDetails createEntityWithoutCopyingId(UserAddressDetailsModel addressModel) {
		UserAddressDetails addressEntity = new UserAddressDetails();

		addressEntity.setHomeNumber(addressModel.getHomeNumber());
		addressEntity.setAddressLine1(addressModel.getAddressLine1());
		addressEntity.setAddressLine2(addressModel.getAddressLine2());
		addressEntity.setLocality(addressModel.getLocality());
		addressEntity.setCity(addressModel.getCity());
		addressEntity.setSubDistrict(addressModel.getSubDistrict());
		addressEntity.setDistrict(addressModel.getDistrict());
		addressEntity.setState(addressModel.getState());
		addressEntity.setCountry(addressModel.getCountry());
		addressEntity.setPincode(addressModel.getPincode());
		addressEntity.setEmailId(addressModel.getEmailId());
		addressEntity.setAlternateEmailId(addressModel.getAlternateEmailId());
		addressEntity.setMobileNumber(addressModel.getMobileNumber());
		addressEntity.setAlternateMobileNumber(addressModel.getAlternateMobileNumber());

		return addressEntity;
	}

	private static UserAddressDetailsModel createServiceModel(UserAddressDetails addressEntity) {
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
