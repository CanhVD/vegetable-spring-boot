package com.example.vegetable_shop.service;

import com.example.vegetable_shop.response.PageResponse;

import java.util.List;

public interface BaseService<T, D> {

    PageResponse<List<T>> getPage(Integer page, Integer size);

    List<T> findAll();

    T findById(D id);

    T save(T user);

    void deleteById(D id);
}