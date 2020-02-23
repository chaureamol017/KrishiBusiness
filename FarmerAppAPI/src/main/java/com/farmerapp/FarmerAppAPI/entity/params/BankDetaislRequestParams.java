/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.entity.params;

/**
 *
 * @author Amol
 */
public class BankDetaislRequestParams {
    private String userBankDetailsId;
    private String userId;
    private String bankName;
    private String branchName;
    private String ifscCode;

    public String getUserBankDetailsId() {
        return userBankDetailsId;
    }

    public void setUserBankDetailsId(String userBankDetailsId) {
        this.userBankDetailsId = userBankDetailsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    
}
