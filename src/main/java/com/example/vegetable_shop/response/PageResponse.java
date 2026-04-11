package com.example.vegetable_shop.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponse<T> {
    private long total;
    private T result;
}
