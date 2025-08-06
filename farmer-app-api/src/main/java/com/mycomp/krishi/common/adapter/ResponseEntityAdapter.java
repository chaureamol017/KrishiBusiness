package com.mycomp.krishi.common.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityAdapter<I, R, M> {
    private WebAdapter<I, R, M> webAdaptor;

    public ResponseEntityAdapter(WebAdapter<I, R, M> webAdaptor) {
        this.webAdaptor = webAdaptor;
    }

    public ResponseEntity<List<R>> createResponseEntity(List<M> models) {
        if (models != null) {
            final List<R> response = webAdaptor.toWeb(models);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<R> createResponseEntity(M model) {
        if (model != null) {
            final R response = webAdaptor.toWeb(model);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
