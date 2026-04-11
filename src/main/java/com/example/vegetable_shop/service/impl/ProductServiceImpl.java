package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.repository.ProductRepository;
import com.example.vegetable_shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        super(productRepository);
    }

    @Override
    public List<Product> getProductByStatus(Boolean status) {
        return productRepository.findByStatus(status);
    }
}
