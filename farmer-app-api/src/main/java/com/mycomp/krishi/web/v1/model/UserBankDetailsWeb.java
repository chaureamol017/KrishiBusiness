package com.mycomp.krishi.web.v1.model;

public class UserBankDetailsWeb {
    private Long userBankDetailsId;
    private Long userId;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String accountNumber;
    private String accountType;
    
	public Long getUserBankDetailsId() {
		return userBankDetailsId;
	}
	public void setUserBankDetailsId(Long userBankDetailsId) {
		this.userBankDetailsId = userBankDetailsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
