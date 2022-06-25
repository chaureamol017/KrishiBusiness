/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.common.operations;

import java.util.List;

/**
 *
 * @author Amol
 */
public class CommonUtils {

    public static <T> boolean checkIfListNotEmpty(List<T> lst) {
        return (checkIfNotNull(lst) && !lst.isEmpty());
    }

    public static boolean checkIfNotNull(Object o) {
        return (o != null);
    }

    public static boolean checkIfNull(Object o) {
        return (o == null);
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == s2;
        } else {
            return s1.equals(s2);
        }
    }

    public static boolean isNullOrEmpty(String str) {
        if (checkIfNull(str)) {
            return true;
        } else {
            return str.length() == 0;
        }
    }

    public static String getString(Object o) {
        if (checkIfNotNull(o)) {
            return o.toString();
        }
        return null;
    }

}
