package com.example.assignment1.services;

import com.example.assignment1.database.Product;
import com.example.assignment1.database.UserBasket;
import com.example.assignment1.models.AddProductInfoItem;
import com.example.assignment1.models.AddProductToBasketRequest;
import com.example.assignment1.repositories.ProductRepository;
import com.example.assignment1.repositories.UserBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserBasketService {

    @Autowired
    private UserBasketRepository userBasketRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addProductToBasket(AddProductToBasketRequest request) throws Exception {
        // Validation
        validateAddProductToBasket(request);

        List<Product> allProducts = productRepository.findAll();
        List<UserBasket> userBasketEntities = userBasketRepository.findByUserId(request.getUserId());

        Map<Long, Integer> productIdToAmount = allProducts
                .stream()
                .collect(Collectors.toMap(Product::getId, Product::getStock));

        for (AddProductInfoItem addProductInfo : request.getAddProductInfos()) {
            long productId = addProductInfo.getProductId();
            List<UserBasket> userBasketFilteredEntities = userBasketEntities
                    .stream().filter(x -> x.getProductId() == productId)
                    .collect(Collectors.toList());

            UserBasket entity = getEntity(userBasketFilteredEntities, addProductInfo);

            if (entity.getUserId() == 0) {
                entity.setUserId(request.getUserId());
                userBasketRepository.save(entity);
            } else {
                int newAmount = entity.getAmount() + addProductInfo.getAmount();
                if (newAmount > productIdToAmount.get(productId)) {
                    newAmount = productIdToAmount.get(productId);
                }
                entity.setAmount(newAmount);
                userBasketRepository.save(entity);
            }
        }
    }

    private void validateAddProductToBasket(AddProductToBasketRequest request) throws Exception {
        if (request == null) {
            throw new Exception("request is required.");
        }
        if (request.getUserId() <= 0L) {
            throw new Exception("userId is required");
        }
        if (request.getAddProductInfos() == null ||
            request.getAddProductInfos().isEmpty()) {
            throw new Exception("addProductInfos is required.");
        }
        boolean anyInvalidAmount = request.getAddProductInfos()
                .stream()
                .anyMatch(x -> x.getAmount() < 0);
        if (anyInvalidAmount) {
            throw new Exception("amount is invalid");
        }

        // Validate ProductId is invalid
        List<Product> allProducts = productRepository.findAll();
        List<Long> allProductIds = allProducts
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        List<Long> productIdsFromRequest = request.getAddProductInfos()
                .stream()
                .map(AddProductInfoItem::getProductId)
                .collect(Collectors.toList());

        List<Long> invalidProductIds = productIdsFromRequest
                .stream()
                .filter(x -> !allProductIds.contains(x))
                .collect(Collectors.toList());

        if (!invalidProductIds.isEmpty()) {
            throw new Exception("productId is invalid");
        }

        // Validate amount is more than stock
        Map<Long, Integer> productIdToAmount = allProducts
                .stream()
                .collect(Collectors.toMap(Product::getId, Product::getStock));

        if (request.getAddProductInfos() != null &&
                !request.getAddProductInfos().isEmpty()) {
            for (AddProductInfoItem addProductInfo : request.getAddProductInfos()) {
                int amountFromRequest = addProductInfo.getAmount();
                long productId = addProductInfo.getProductId();
                int stock = productIdToAmount.get(productId);
                if (amountFromRequest > stock) {
                    throw new Exception("amount cannot be more than stock");
                }
            }
        }
    }

    private UserBasket getEntity(List<UserBasket> allEntities, AddProductInfoItem addProductInfoItem) {
        UserBasket result;
        List<UserBasket> userBasketFilteredEntities = allEntities
                .stream().filter(x -> x.getProductId() == addProductInfoItem.getProductId())
                .collect(Collectors.toList());

        if (userBasketFilteredEntities.isEmpty()) {
            result = new UserBasket(
                    0L,
                    addProductInfoItem.getProductId(),
                    addProductInfoItem.getAmount()
            );
        } else {
            result = userBasketFilteredEntities.get(0);
        }

        return result;
    }

    // For Unit test only
    public void setUserBasketRepository(UserBasketRepository userBasketRepository) {
        this.userBasketRepository = userBasketRepository;
    }

    // For Unit test only
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
