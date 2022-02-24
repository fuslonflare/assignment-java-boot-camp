package com.example.assignment1.services;

import com.example.assignment1.database.Product;
import com.example.assignment1.models.BaseSearchResultModel;
import com.example.assignment1.models.ProductFilter;
import com.example.assignment1.models.ProductInfo;
import com.example.assignment1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public BaseSearchResultModel<ProductInfo> search(ProductFilter filter) {
        BaseSearchResultModel<ProductInfo> result = new BaseSearchResultModel<>();
        List<Product> queryResult = productRepository.findByName(filter.getKeyword().trim());
        int totalPage = (int)Math.ceil((double)queryResult.size() / filter.getItemPerPage());
        int totalItem = queryResult.size();

        // Skip and take (pagination)
        int firstIndex = filter.getItemPerPage() * (filter.getPage() - 1) ;
        int lastIndex = firstIndex + (filter.getItemPerPage());

        // Exception
        if (firstIndex > queryResult.size() - 1) {
            queryResult = new ArrayList<>();
        } else {
            if (lastIndex > queryResult.size() - 1) {
                lastIndex = queryResult.size();
            }
            queryResult = queryResult.subList(firstIndex, lastIndex);
        }

        // Construct result
        List<ProductInfo> productInfos = new ArrayList<>();
        if (!queryResult.isEmpty()) {
            for (Product product : queryResult) {
                productInfos.add(new ProductInfo(
                        product.getId(),
                        product.getName(),
                        product.getOriginalPrice(),
                        product.getPrice(),
                        product.getRate(),
                        product.getThumbnail(),
                        product.getStock(),
                        product.getTotalReviewer()
                ));
            }
        }

        result.setItems(productInfos);
        result.setPage(filter.getPage());
        result.setItemPerPage(filter.getItemPerPage());
        result.setTotalItems(totalItem);
        result.setTotalPage(totalPage);

        return result;
    }

    // For Unit test only
    public void setProductRepository(ProductRepository ProductRepository) {
        this.productRepository = ProductRepository;
    }
}
