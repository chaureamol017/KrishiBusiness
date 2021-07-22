/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.business.krishi.service.api;

import com.mycomp.business.krishi.service.api.model.UserAddressDetailsModel;

import java.util.List;

/**
 *
 * @author Amol
 */
public interface UserAddressDetailsService {

    public UserAddressDetailsModel saveAddressDetails(UserAddressDetailsModel addressModel);

    public UserAddressDetailsModel updateAddressDetails(UserAddressDetailsModel addressModel);
    
    public UserAddressDetailsModel getAddressDetails(Long userAddressDetailsId);
    
    public List<UserAddressDetailsModel> getAddressDetailsByUserId(Long userId);
    
    public boolean deleteAddressDetails(Long userAddressDetailsId);
}
