package com.mycomp.business.krishi.api.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityAdaptor<I, O> {
    private WebAdaptor<I, O> webAdaptor;

    public ResponseEntityAdaptor(WebAdaptor<I, O> webAdaptor) {
        this.webAdaptor = webAdaptor;
    }

    public ResponseEntity<List<I>> createResponseEntity(List<O> models) {
        if (models != null) {
            final List<I> response = webAdaptor.toWebModel(models);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<I> createResponseEntity(O model) {
        if (model != null) {
            final I response = webAdaptor.toWebModel(model);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
