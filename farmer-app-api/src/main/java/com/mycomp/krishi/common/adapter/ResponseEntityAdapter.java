package com.mycomp.krishi.common.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityAdapter<I, R, M> {
    private WebAdapter<I, R, M> webAdaptor;

    public ResponseEntityAdapter(WebAdapter<I, R, M> webAdaptor) {
        this.webAdaptor = webAdaptor;
    }

    public ResponseEntity<List<R>> createResponseEntity(List<M> models, Boolean successIfNull) {
        if (models != null) {
            final List<R> response = webAdaptor.toWeb(models);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<R> createResponseEntity(M model, Boolean successIfNull) {
        if (model != null) {
            final R response = webAdaptor.toWeb(model);
            return toResponseEntity(response, HttpStatus.OK);
        } else {
            final HttpStatus httpStatus = successIfNull ?  HttpStatus.OK : HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, httpStatus);
        }
    }

    private <R> ResponseEntity<R> toResponseEntity(R response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
