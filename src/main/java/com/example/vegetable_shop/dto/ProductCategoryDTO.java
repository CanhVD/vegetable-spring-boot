package com.example.vegetable_shop.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ProductCategoryDTO {

    private Long id;

    private ProductDTO product;

    private CategoryDTO category;

    private String note;

    private String createdBy;

    private Instant createdDate;

    private String updatedBy;

    private Instant updatedDate;
}
