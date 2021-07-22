/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.dao.api.UserAddressDetailsDao;
import com.mycomp.business.krishi.entity.UserAddressDetails;
import com.mycomp.business.krishi.service.api.UserAddressDetailsService;
import com.mycomp.business.krishi.service.api.adaptor.UserAddressDetailsAdaptor;
import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class UserAddressDetailsServiceImpl implements UserAddressDetailsService {

	@Autowired
	private UserAddressDetailsDao userAddressDetailsDao;

	@Override
	public UserAddressDetailsModel saveAddressDetails(UserAddressDetailsModel addressModel) {
		UserAddressDetails entityToSave = UserAddressDetailsAdaptor.toEntityMinimal(addressModel);
		entityToSave = userAddressDetailsDao.save(entityToSave);

		UserAddressDetailsModel model = UserAddressDetailsAdaptor.toServiceModel(entityToSave);

		return model;
	}

	@Override
	public UserAddressDetailsModel updateAddressDetails(UserAddressDetailsModel addressModel) {
		UserAddressDetails entityToUpdate = UserAddressDetailsAdaptor.toEntity(addressModel);
		entityToUpdate = userAddressDetailsDao.saveAndFlush(entityToUpdate);

		UserAddressDetailsModel model = UserAddressDetailsAdaptor.toServiceModel(entityToUpdate);

		return model;
	}

	@Override
	public UserAddressDetailsModel getAddressDetails(Long userAddressDetailsId) {
		Optional<UserAddressDetails> userAddressDetails = userAddressDetailsDao.findById(userAddressDetailsId);
		if (userAddressDetails.isPresent()) {
			return UserAddressDetailsAdaptor.toServiceModel(userAddressDetails.get());
		}
		return null;
	}

	@Override
	public List<UserAddressDetailsModel> getAddressDetailsByUserId(Long userId) {
		List<UserAddressDetails> userAddressDetails = userAddressDetailsDao.findUserAddressDetailsByUser(userId);

		return UserAddressDetailsAdaptor.toServiceModel(userAddressDetails);
	}

	@Override
	public boolean deleteAddressDetails(Long userAddressDetailsId) {
		userAddressDetailsDao.deleteById(userAddressDetailsId);
		return true;
	}

}
