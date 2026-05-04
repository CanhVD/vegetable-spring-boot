package com.example.vegetable_shop.service;

import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.request.AddProductRequest;

import java.util.List;

public interface ProductService extends BaseService<Product, ProductDTO, Long> {
    List<Product> getProductByStatus(Boolean status);
    ProductDTO findByIdWithCategory(Long id);
    ProductDTO addProduct(AddProductRequest request);
}
