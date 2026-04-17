package com.example.vegetable_shop.controller;

import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.CategoryService;
import com.example.vegetable_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController extends BaseRestController {

    private final CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<BaseResponse<List<CategoryDTO>>> getAllCategory(
    ) {
        return execute(categoryService::findAll);
    }
}
