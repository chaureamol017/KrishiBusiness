/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.common.implementation.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amol
 */
public class ApiResponseData {

    private List<Object> dataList;

    public ApiResponseData() {
        dataList = new ArrayList<>();
    }

    public void addData(Object data) {
        dataList.add(data);
    }

    public List<Object> getDataList() {
        return dataList;
    }
}
