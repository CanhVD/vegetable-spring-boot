package com.example.vegetable_shop.service;

import com.example.vegetable_shop.request.PageCustomRequest;
import com.example.vegetable_shop.response.PageResponse;

import java.util.List;

public interface BaseService<T, D, ID> {

    PageResponse<List<D>> getPage(PageCustomRequest request);

    PageResponse<List<D>> getPageByKeyword(PageCustomRequest request);

    List<D> findAll();

    D findById(ID id);

    D save(T entity);

    D update(ID id, D dto);

    void delete(ID id);
}