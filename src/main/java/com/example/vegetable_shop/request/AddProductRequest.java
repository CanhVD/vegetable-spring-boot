package com.example.vegetable_shop.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {

    @NotNull(message = "name is not null")
    @NotEmpty(message = "name is not empty")
    private String name;

    private Integer quantity;

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
