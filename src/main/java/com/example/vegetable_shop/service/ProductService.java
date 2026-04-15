package com.example.vegetable_shop.service;

import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.model.Product;

import java.util.List;

public interface ProductService extends BaseService <ProductDTO, Long> {
    List<Product> getProductByStatus(Boolean status);
}
