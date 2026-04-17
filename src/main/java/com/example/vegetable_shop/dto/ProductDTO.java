package com.example.vegetable_shop.dto;

import com.example.vegetable_shop.model.ProductCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    private List<CategoryDTO> categoryList;
}
