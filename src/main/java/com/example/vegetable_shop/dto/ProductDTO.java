package com.example.vegetable_shop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer percent;

    private Double weight;

    private String unit;

    private String origin;

    private String shortDes;

    private String description;

    private Boolean status;

    private String image;
}
