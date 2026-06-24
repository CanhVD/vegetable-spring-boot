package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.exception.BindingResultException;
import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.repository.ProductCategoryRepository;
import com.example.vegetable_shop.repository.ProductRepository;
import com.example.vegetable_shop.request.AddProductRequest;
import com.example.vegetable_shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setCategoryList(product.getProductCategories().stream().map(item -> modelMapper.map(item.getCategory(), CategoryDTO.class)).toList());
        return productDTO;
    }

    @Override
    public ProductDTO addProduct(AddProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        return save(product);
    }
}
