/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.UserAddressDetailsRepository;
import com.mycomp.krishi.persistence.entity.UserAddressDetails;
import com.mycomp.krishi.service.adapter.UserAddressDetailsAdapter;
import com.mycomp.krishi.service.api.UserAddressDetailsService;
import com.mycomp.krishi.service.model.UserAddressDetailsModel;

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
	private ModelAdapter<UserAddressDetailsModel, UserAddressDetails> modelAdapter = UserAddressDetailsAdapter.INSTANCE;

	@Autowired
	private UserAddressDetailsRepository userAddressDetailsRepository;

	@Override
	public UserAddressDetailsModel saveAddressDetails(UserAddressDetailsModel addressModel) {
		UserAddressDetails entityToSave = modelAdapter.toEntityMinimal(addressModel);
		entityToSave = userAddressDetailsRepository.save(entityToSave);

		return modelAdapter.toModel(entityToSave);
	}

	@Override
	public UserAddressDetailsModel updateAddressDetails(UserAddressDetailsModel addressModel) {
		UserAddressDetails entityToUpdate = modelAdapter.toEntity(addressModel);
		entityToUpdate = userAddressDetailsRepository.saveAndFlush(entityToUpdate);

		return modelAdapter.toModel(entityToUpdate);
	}

	@Override
	public UserAddressDetailsModel getAddressDetails(Long userAddressDetailsId) {
		Optional<UserAddressDetails> userAddressDetails = userAddressDetailsRepository.findById(userAddressDetailsId);
		if (userAddressDetails.isPresent()) {
			return modelAdapter.toModel(userAddressDetails.get());
		}
		return null;
	}

	@Override
	public List<UserAddressDetailsModel> getAddressDetailsByUserId(Long userId) {
		List<UserAddressDetails> userAddressDetails = userAddressDetailsRepository.findByUserId(userId);

		return modelAdapter.toModel(userAddressDetails);
	}

	@Override
	public boolean deleteAddressDetails(Long userAddressDetailsId) {
		userAddressDetailsRepository.deleteById(userAddressDetailsId);
		return true;
	}
}
