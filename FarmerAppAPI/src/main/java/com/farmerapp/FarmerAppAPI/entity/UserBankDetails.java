/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.FarmerAppAPI.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Amol
 */

@Entity
@Table(name = "user_bank_details")
@Setter
@Getter
public class UserBankDetails implements Serializable {
    @Id
    @Column(name = "user_bank_details_id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String userBankDetailsId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "ifsc_code")
    private String ifscCode;
    
}
