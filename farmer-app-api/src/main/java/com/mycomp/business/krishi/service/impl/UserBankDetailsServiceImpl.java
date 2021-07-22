/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.impl;

import com.mycomp.business.krishi.dao.api.UserBankDetailsDao;
import com.mycomp.business.krishi.entity.UserBankDetails;
import com.mycomp.business.krishi.service.api.UserBankDetailsService;
import com.mycomp.business.krishi.service.api.adaptor.UserBankDetailsAdaptor;
import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;

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

	@Autowired
	private UserBankDetailsDao userBankDetailsDao;

	@Override
	public UserBankDetailsModel saveBankDetails(UserBankDetailsModel bankDetailsModel) {
		UserBankDetails entity = UserBankDetailsAdaptor.toEntityMinimal(bankDetailsModel);
		entity = userBankDetailsDao.save(entity);

		UserBankDetailsModel model = UserBankDetailsAdaptor.toServiceModel(entity);

		return model;
	}

	@Override
	public UserBankDetailsModel updateBankDetails(UserBankDetailsModel bankDetailsModel) {
		UserBankDetails entity = UserBankDetailsAdaptor.toEntity(bankDetailsModel);
		entity = userBankDetailsDao.saveAndFlush(entity);

		UserBankDetailsModel model = UserBankDetailsAdaptor.toServiceModel(entity);

		return model;
	}

	@Override
	public UserBankDetailsModel getBankDetails(Long userBankDetailsId) {
		Optional<UserBankDetails> optionalEntity = userBankDetailsDao.findById(userBankDetailsId);

		if (optionalEntity.isPresent()) {
			return UserBankDetailsAdaptor.toServiceModel(optionalEntity.get());
		}
		return null;
	}

	@Override
	public List<UserBankDetailsModel> getBankDetailsByUserId(Long userId) {
		List<UserBankDetails> userAddressDetails = userBankDetailsDao.findUserBankDetailsByUser(userId);

		return UserBankDetailsAdaptor.toServiceModel(userAddressDetails);
	}

	@Override
	public boolean deleteAddressDetails(Long userBankDetailsId) {
		userBankDetailsDao.deleteById(userBankDetailsId);
		return true;
	}
}
