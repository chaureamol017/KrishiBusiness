/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.krishi.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mycomp.krishi.persistence.entity.type.AccountType;

/**
 *
 * @author Amol
 */

@Entity
@Table(name = "user_bank_details")
public class UserBankDetails implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "user_bank_details_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userBankDetailsId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
