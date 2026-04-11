package com.example.vegetable_shop.service;

import com.example.vegetable_shop.model.Product;

import java.util.List;

public interface ProductService extends BaseService <Product, Long> {
    List<Product> getProductByStatus(Boolean status);
}
