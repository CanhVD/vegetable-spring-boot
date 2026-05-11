package com.example.vegetable_shop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private Long id;

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

    private Integer saleQuantity;

    private List<CategoryDTO> categoryList;
}
