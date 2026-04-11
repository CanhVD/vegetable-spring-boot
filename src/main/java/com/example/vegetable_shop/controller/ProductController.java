package com.example.vegetable_shop.controller;

import com.example.vegetable_shop.model.Product;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController extends BaseRestController {

    private final ProductService productService;

    @GetMapping("search")
    public ResponseEntity<BaseResponse<PageResponse<List<Product>>>> getUserBySearch(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return execute(() -> productService.getPage(page, size));
    }
}
