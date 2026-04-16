package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.exception.BindingResultException;
import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.model.ProductCategory;
import com.example.vegetable_shop.repository.ProductCategoryRepository;
import com.example.vegetable_shop.repository.ProductRepository;
import com.example.vegetable_shop.service.ProductService;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductDTO, Long> implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ProductCategoryRepository productCategoryRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        super(productRepository, modelMapper, Product.class, ProductDTO.class);
    }

    @Override
    public List<Product> getProductByStatus(Boolean status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public ProductDTO findByIdWithCategory(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new BindingResultException("Product is not found"));
        Set<Long> ids = product.getProductCategories().stream().map(ProductCategory::getId).collect(Collectors.toSet());
        List<ProductCategory> productCategories = productCategoryRepository.findByIdIn(ids);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setCategoryList(productCategories.stream().map(item -> modelMapper.map(item.getCategory(), CategoryDTO.class)).toList());
        return productDTO;
    }
}
