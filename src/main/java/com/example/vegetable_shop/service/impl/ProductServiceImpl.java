package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.repository.ProductRepository;
import com.example.vegetable_shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductDTO, Long> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        super(productRepository, modelMapper, Product.class, ProductDTO.class);
    }

    @Override
    public List<Product> getProductByStatus(Boolean status) {
        return productRepository.findByStatus(status);
    }
}
