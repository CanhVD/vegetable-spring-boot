package com.example.vegetable_shop.controller.client;

import com.example.vegetable_shop.controller.BaseRestController;
import com.example.vegetable_shop.dto.CategoryDTO;
import com.example.vegetable_shop.request.PageCustomRequest;
import com.example.vegetable_shop.response.BaseResponse;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.CategoryService;
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

    @GetMapping("page")
    public ResponseEntity<BaseResponse<PageResponse<List<CategoryDTO>>>> getPageCategory(
            @ModelAttribute PageCustomRequest request
    ) {
        return execute(() -> categoryService.getPage(request));
    }
}
