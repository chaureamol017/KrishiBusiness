package com.mycomp.common.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityHelper {


    public static  <R> ResponseEntity<R> toSuccessResponseEntity(R response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static  <R> ResponseEntity<R> toNotFounfResponseEntity(R response) {
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    public static  <R> ResponseEntity<R> toResponseEntity(R response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
