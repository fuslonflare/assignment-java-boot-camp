package com.example.assignment1.controllers;

import com.example.assignment1.models.AddProductInfoItem;
import com.example.assignment1.models.AddProductToBasketRequest;
import com.example.assignment1.repositories.ProductRepository;
import com.example.assignment1.repositories.UserBasketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserBasketControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserBasketRepository userBasketRepository;

    @Test
    void addProductToBasket_success() {
        // Arrange
        String errorMessage = null;
        List<AddProductInfoItem> addProductInfoItemList = new ArrayList<>();
        addProductInfoItemList.add(new AddProductInfoItem(2, 1L));
        addProductInfoItemList.add(new AddProductInfoItem(6, 3L));
        AddProductToBasketRequest request = new AddProductToBasketRequest(addProductInfoItemList, 1L);

        // Act
        try {
            testRestTemplate.postForObject(
                    "/userBasket/addProductToBasket",
                    request,
                    Void.class);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        // Assert
        assertNull(errorMessage);
    }
}