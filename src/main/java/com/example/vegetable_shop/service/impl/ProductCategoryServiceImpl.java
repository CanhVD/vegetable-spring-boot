package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.ProductCategoryDTO;
import com.example.vegetable_shop.model.Category;
import com.example.vegetable_shop.model.ProductCategory;
import com.example.vegetable_shop.repository.CategoryRepository;
import com.example.vegetable_shop.repository.ProductCategoryRepository;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, ProductCategoryDTO, Long> implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        super(productCategoryRepository, modelMapper, ProductCategory.class, ProductCategoryDTO.class);
    }

    @Override
    public PageResponse<List<ProductCategoryDTO>> getPageByCategory(Long categoryId, int pageIndex, int pageSize) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("category is not found"));
        Page<ProductCategory> entityPage = productCategoryRepository.findByCategory(category, PageRequest.of(pageIndex - 1, pageSize));

        List<ProductCategoryDTO> dtoList = entityPage.getContent()
                .stream()
                .map(item -> modelMapper.map(item, ProductCategoryDTO.class))
                .toList();

        return PageResponse.<List<ProductCategoryDTO>>builder()
                .result(dtoList)
                .total(entityPage.getTotalElements())
                .build();
    }
}
