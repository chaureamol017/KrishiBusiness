/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.web.model;

/**
 *
 * @author Amol
 */
public class AddressDetaislRequestParams {
    private String userAddressDetailsId;
    private String userId;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String cityName;
    private String tahsilName;
    private String stateName;
    private String pincode;

    public String getUserAddressDetailsId() {
        return userAddressDetailsId;
    }

    public void setUserAddressDetailsId(String userAddressDetailsId) {
        this.userAddressDetailsId = userAddressDetailsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTahsilName() {
        return tahsilName;
    }

    public void setTahsilName(String tahsilName) {
        this.tahsilName = tahsilName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
    
}
