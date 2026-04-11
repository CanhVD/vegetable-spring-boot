package com.example.vegetable_shop.repository;

import com.example.vegetable_shop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    List<Product> findByStatus(Boolean status);
}
