/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.UserBankDetailsModel;

import java.util.List;

/**
 *
 * @author Amol
 */
public interface UserBankDetailsService {

    public UserBankDetailsModel saveBankDetails(UserBankDetailsModel addressModel);

    public UserBankDetailsModel updateBankDetails(UserBankDetailsModel addressModel);
    
    public UserBankDetailsModel getBankDetails(Long userAddressDetailsId);
    
    public List<UserBankDetailsModel> getBankDetailsByUserId(Long userId);
    
    public boolean deleteAddressDetails(Long userBankDetailsId);
}
