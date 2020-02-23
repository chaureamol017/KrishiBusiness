/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.common.implementation.response;

import com.farmerapp.common.constants.Constants;

/**
 *
 * @author Amol
 */
public class ApiResponse {
    private boolean success;
    private int totalCount;
    private String data;

    public ApiResponse() {
        success = false;
        totalCount = 0;
        data = Constants.BLANK_JSON;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
