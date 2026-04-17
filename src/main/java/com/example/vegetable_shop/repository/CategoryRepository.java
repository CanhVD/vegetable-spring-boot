package com.example.vegetable_shop.repository;

import com.example.vegetable_shop.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
