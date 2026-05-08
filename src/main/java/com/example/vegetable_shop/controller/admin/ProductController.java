package com.example.vegetable_shop.controller.admin;

import com.example.vegetable_shop.controller.BaseRestController;
import com.example.vegetable_shop.dto.ProductDTO;
import com.example.vegetable_shop.exception.BindingResultException;
import com.example.vegetable_shop.request.AddProductRequest;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ClientProductController")
@RequestMapping("api/v1/admin/product")
@RequiredArgsConstructor
public class ProductController extends BaseRestController {
    private final ProductService productService;

    @PostMapping("add")
    public ResponseEntity<BaseResponse<ProductDTO>> addProduct(@Valid @RequestBody AddProductRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }

        return execute(() -> productService.addProduct(request));
    }
}
