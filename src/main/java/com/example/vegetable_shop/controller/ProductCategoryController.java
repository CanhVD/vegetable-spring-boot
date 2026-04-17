package com.example.vegetable_shop.controller;

import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.dto.ProductCategoryDTO;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.service.CategoryService;
import com.example.vegetable_shop.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product-category")
@RequiredArgsConstructor
public class ProductCategoryController extends BaseRestController {

    private final ProductCategoryService productCategoryService;

    @GetMapping("list")
    public ResponseEntity<BaseResponse<List<ProductCategoryDTO>>> getAllCategory(
    ) {
        return execute(productCategoryService::findAll);
    }
}
