/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.impl;

import com.mycomp.common.adapter.ModelAdapter;
import com.mycomp.krishi.dataprovider.repository.UserBankDetailsRepository;
import com.mycomp.krishi.persistence.entity.UserBankDetails;
import com.mycomp.krishi.service.adapter.UserBankDetailsAdapter;
import com.mycomp.krishi.service.api.UserBankDetailsService;
import com.mycomp.krishi.service.model.UserBankDetailsModel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amol
 */
@Service
public class UserBankDetailsServiceImpl implements UserBankDetailsService {
	private ModelAdapter<UserBankDetailsModel, UserBankDetails> modelAdapter = UserBankDetailsAdapter.INSTANCE;

	@Autowired
	private UserBankDetailsRepository userBankDetailsRepository;

	@Override
	public UserBankDetailsModel saveBankDetails(UserBankDetailsModel bankDetailsModel) {
		UserBankDetails entity = modelAdapter.toEntityMinimal(bankDetailsModel);
		entity = userBankDetailsRepository.save(entity);

		return modelAdapter.toModel(entity);
	}

	@Override
	public UserBankDetailsModel updateBankDetails(UserBankDetailsModel bankDetailsModel) {
		UserBankDetails entity = modelAdapter.toEntity(bankDetailsModel);
		entity = userBankDetailsRepository.saveAndFlush(entity);

		return modelAdapter.toModel(entity);
	}

	@Override
	public UserBankDetailsModel getBankDetails(Long userBankDetailsId) {
		Optional<UserBankDetails> optionalEntity = userBankDetailsRepository.findById(userBankDetailsId);

		if (optionalEntity.isPresent()) {
			return modelAdapter.toModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public List<UserBankDetailsModel> getBankDetailsByUserId(Long userId) {
		List<UserBankDetails> userAddressDetails = userBankDetailsRepository.findByUserId(userId);

		return modelAdapter.toModel(userAddressDetails);
	}

	@Override
	public boolean deleteBankDetails(Long userBankDetailsId) {
		userBankDetailsRepository.deleteById(userBankDetailsId);
		return true;
	}
}
