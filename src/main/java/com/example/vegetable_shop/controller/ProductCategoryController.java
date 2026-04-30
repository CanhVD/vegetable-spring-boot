package com.example.vegetable_shop.controller;

import com.example.vegetable_shop.dto.ProductCategoryDTO;
import com.example.vegetable_shop.request.PageProductCategoryRequest;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product-category")
@RequiredArgsConstructor
public class ProductCategoryController extends BaseRestController {

    private final ProductCategoryService productCategoryService;

    @GetMapping("list")
    public ResponseEntity<BaseResponse<List<ProductCategoryDTO>>> getAllProductCategory(
    ) {
        return execute(productCategoryService::findAll);
    }

    @GetMapping("page")
    public ResponseEntity<BaseResponse<PageResponse<List<ProductCategoryDTO>>>> getPageProductCategory(
            @ModelAttribute PageProductCategoryRequest request
    ) {
        return execute(() -> productCategoryService.getPageByCategory(
                request.getCategoryId(), request.getPageIndex(), request.getPageSize())
        );
    }
}