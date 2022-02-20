package com.example.assignment1.controllers;

import com.example.assignment1.models.BaseSearchResultModel;
import com.example.assignment1.models.ProductFilter;
import com.example.assignment1.models.ProductInfo;
import com.example.assignment1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/search")
    public BaseSearchResultModel<ProductInfo> search(@RequestBody ProductFilter productFilter) {
        if (productFilter.getPage() == 0) {
            productFilter.setPage(1);
        }
        if (productFilter.getItemPerPage() == 0) {
            productFilter.setItemPerPage(20);
        }
        if (productFilter.getKeyword() == null) {
            productFilter.setKeyword("");
        }
        return productService.search(productFilter);
    }

}
