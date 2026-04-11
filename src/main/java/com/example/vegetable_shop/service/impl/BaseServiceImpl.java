package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.repository.BaseRepository;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class BaseServiceImpl<T, D> implements BaseService<T, D> {

    private final BaseRepository<T, D> baseRepository;

    public BaseServiceImpl(BaseRepository<T, D> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public PageResponse<List<T>> getPage(Integer page, Integer size) {
        Page<T> userPage = baseRepository.findAll(PageRequest.of(page - 1, size));
        return PageResponse.<List<T>>builder()
                .result(userPage.getContent())
                .total(userPage.getTotalElements())
                .build();
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public T findById(D id) {
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public T save(T user) {
        return baseRepository.save(user);
    }

    @Override
    public void deleteById(D id) {
        baseRepository.deleteById(id);
    }
}
