package com.example.vegetable_shop.controller;

import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.request.PageCustomRequest;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController extends BaseRestController {

    private final ProductService productService;

    @GetMapping("search")
    public ResponseEntity<BaseResponse<PageResponse<List<ProductDTO>>>> getUserBySearch(
            @ModelAttribute PageCustomRequest request
    ) {
        return execute(() -> productService.getPageByKeyword(request));
    }

    @GetMapping("list")
    public ResponseEntity<BaseResponse<List<ProductDTO>>> getAllProduct() {
        return execute(productService::findAll);
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<ProductDTO>> getById(@PathVariable Long id) {
        return execute(() -> productService.findByIdWithCategory(id));
    }
}
