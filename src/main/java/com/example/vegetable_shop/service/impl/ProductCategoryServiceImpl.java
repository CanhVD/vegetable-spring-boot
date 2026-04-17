package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.ProductCategoryDTO;
import com.example.vegetable_shop.model.ProductCategory;
import com.example.vegetable_shop.repository.ProductCategoryRepository;
import com.example.vegetable_shop.service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, ProductCategoryDTO, Long> implements ProductCategoryService {
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        super(productCategoryRepository, modelMapper, ProductCategory.class, ProductCategoryDTO.class);
    }
}
