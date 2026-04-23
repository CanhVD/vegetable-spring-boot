package com.example.vegetable_shop.request;

import com.example.vegetable_shop.util.enums.OrderBy;
import lombok.Data;

@Data
public class PageCustomRequest {
    private Integer page;
    private Integer size;
    private String keyword;
    private String property;
    private OrderBy orderBy;

    public PageCustomRequest() {
        this.page = 1;
        this.size = 10;
        this.keyword = "";
        this.property = "id";
        this.orderBy = OrderBy.DESC;
    }
}
