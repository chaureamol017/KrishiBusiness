package com.mycomp.common.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityAdapter<I, O> {
    private WebAdapter<I, O> webAdaptor;

    public ResponseEntityAdapter(WebAdapter<I, O> webAdaptor) {
        this.webAdaptor = webAdaptor;
    }

    public ResponseEntity<List<I>> createResponseEntity(List<O> models) {
        if (models != null) {
            final List<I> response = webAdaptor.toWeb(models);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<I> createResponseEntity(O model) {
        if (model != null) {
            final I response = webAdaptor.toWeb(model);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
