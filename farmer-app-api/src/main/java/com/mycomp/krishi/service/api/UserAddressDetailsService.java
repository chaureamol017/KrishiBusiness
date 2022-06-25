/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.service.api;

import java.util.List;

import com.mycomp.krishi.service.model.UserAddressDetailsModel;

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
