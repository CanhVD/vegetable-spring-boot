package com.example.vegetable_shop.service;

import com.example.vegetable_shop.dto.ProductCategoryDTO;
import com.example.vegetable_shop.model.ProductCategory;
import com.example.vegetable_shop.response.PageResponse;

import java.util.List;

public interface ProductCategoryService extends BaseService<ProductCategory, ProductCategoryDTO, Long> {
    PageResponse<List<ProductCategoryDTO>> getPageByCategory(Long categoryId, int pageIndex, int pageSize);
}
