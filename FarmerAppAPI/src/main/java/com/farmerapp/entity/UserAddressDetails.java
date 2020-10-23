/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "user_address_details")
@Setter
@Getter
public class UserAddressDetails implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "user_address_details_id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String userAddressDetailsId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name = "locality")
    private String locality;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "tahsil_name")
    private String tahsilName;
    @Column(name = "state_name")
    private String stateName;
    @Column(name = "pincode")
    private String pincode;
    
}
