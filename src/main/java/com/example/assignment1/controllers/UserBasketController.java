package com.example.assignment1.controllers;

import com.example.assignment1.models.AddProductToBasketRequest;
import com.example.assignment1.services.UserBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBasketController {

    @Autowired
    private UserBasketService userBasketService;

    @PostMapping("/userBasket/addProductToBasket")
    public ResponseEntity<?> addProductToBasket(@RequestBody AddProductToBasketRequest request) {
        try {
            userBasketService.addProductToBasket(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
