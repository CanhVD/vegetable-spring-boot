package com.example.vegetable_shop.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CategoryDTO {
    private Long id;

    private String name;

    private String description;

    private String createdBy;

    private Instant createdDate;

    private Instant updatedBy;

    private Instant updatedDate;
}
