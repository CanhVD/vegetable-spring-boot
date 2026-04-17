package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.model.Category;
import com.example.vegetable_shop.repository.CategoryRepository;
import com.example.vegetable_shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryDTO, Long> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        super(categoryRepository, modelMapper, Category.class, CategoryDTO.class);
    }
}
