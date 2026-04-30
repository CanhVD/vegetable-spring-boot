package com.example.vegetable_shop.request;

import lombok.Data;

@Data
public class PageProductCategoryRequest {
    private Integer pageIndex;
    private Integer pageSize;
    private Long categoryId;

    public PageProductCategoryRequest() {
        this.pageIndex = 1;
        this.pageSize = 10;
        this.categoryId = 1L;
    }
}
