package com.example.vegetable_shop.repository;

import com.example.vegetable_shop.model.Product;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends BasePageRepository<Product, Long> {
    List<Product> findByStatus(Boolean status);

    @EntityGraph(attributePaths = {
            "productCategories",
            "productCategories.category"
    })
    @NullMarked
    Optional<Product> findById(Long id);
}
