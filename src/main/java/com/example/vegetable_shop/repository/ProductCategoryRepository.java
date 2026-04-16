package com.example.vegetable_shop.repository;

import com.example.vegetable_shop.model.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductCategoryRepository extends BaseRepository<ProductCategory, Long> {
    List<ProductCategory> findByIdIn(Set<Long> ids);
}
