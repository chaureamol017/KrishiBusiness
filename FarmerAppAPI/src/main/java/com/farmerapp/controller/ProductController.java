/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmerapp.controller;

import com.farmerapp.common.response.ApiResponse;
import com.farmerapp.entity.Product;
import com.farmerapp.service.api.product.ProductService;
import com.farmerapp.web.model.ProductRequestParams;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rahul
 */
@RequestMapping("product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody ProductRequestParams requestParams) {
        ApiResponse apiRespoonse = productService.saveProduct(requestParams);
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody ProductRequestParams requestParams) {
        ApiResponse apiRespoonse = productService.updateProduct(requestParams);
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProductList();
    }

    @GetMapping("/byid")
    public Product getProduct(@RequestParam(name = "id") String id) {
        return productService.getProduct(id);
    }

    @GetMapping("/allunsold")
    public ResponseEntity<ApiResponse> findAllUnsoldProducts() {
        ApiResponse apiRespoonse = productService.findAllUnsoldProducts();
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/byuser")
    public ResponseEntity<ApiResponse> findProductByUser(@RequestParam(name = "userId") String userId) {
        ApiResponse apiRespoonse = productService.findProductByUser(userId, false);
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/soldbyuser")
    public ResponseEntity<ApiResponse> findSoldProductByUser(@RequestParam(name = "userId") String userId) {
        ApiResponse apiRespoonse = productService.findProductByUser(userId, true);
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/byJPQL")
    public List<Product> getProductByJPQ() {
        return productService.getProductByJPQ();
    }

    @GetMapping("/byNative")
    public List<Product> getProductByNativeQuery() {
        return productService.getProductByNativeQuery();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse>  deleteProduct(@RequestParam(name = "id") String id) {
        ApiResponse apiRespoonse = productService.deleteProduct(id);
        
        if (apiRespoonse != null) {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(apiRespoonse, HttpStatus.NOT_FOUND);
        }
    }

}
