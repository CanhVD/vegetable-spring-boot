package com.example.vegetable_shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BasePageRepository<T, ID> extends BaseRepository<T, ID> {
    Page<T> findByNameContaining(String keyword, Pageable pageable);
}
