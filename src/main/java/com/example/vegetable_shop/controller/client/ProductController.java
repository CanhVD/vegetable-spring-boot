package com.example.vegetable_shop.controller.client;

import com.example.vegetable_shop.controller.BaseRestController;
import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.request.PageCustomRequest;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/product")
@RequiredArgsConstructor
public class ProductController extends BaseRestController {

    private final ProductService productService;

    @GetMapping("search")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
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
