package com.example.vegetable_shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "unit")
    private String unit;

    @Column(name = "origin")
    private String origin;

    @Column(name = "short_des")
    private String shortDes;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "image")
    private String image;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @OneToMany(mappedBy = "product")
    private Set<ProductCategory> productCategories = new LinkedHashSet<>();
}