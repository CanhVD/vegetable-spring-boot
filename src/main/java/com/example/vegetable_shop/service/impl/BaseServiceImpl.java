package com.example.vegetable_shop.service.impl;

import com.example.vegetable_shop.repository.BaseRepository;
import com.example.vegetable_shop.response.PageResponse;
import com.example.vegetable_shop.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class BaseServiceImpl<T, D, ID> implements BaseService<D, ID> {

    private final ModelMapper modelMapper;

    private final BaseRepository<T, ID> baseRepository;

    private final Class<T> entityClass;

    private final Class<D> dtoClass;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository,
                           ModelMapper modelMapper,
                           Class<T> entityClass,
                           Class<D> dtoClass) {
        this.baseRepository = baseRepository;
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public PageResponse<List<D>> getPage(Integer page, Integer size) {
        Page<T> entityPage = baseRepository.findAll(PageRequest.of(page - 1, size));

        List<D> dtoList = entityPage.getContent()
                .stream()
                .map(item -> modelMapper.map(item, dtoClass))
                .toList();

        return PageResponse.<List<D>>builder()
                .result(dtoList)
                .total(entityPage.getTotalElements())
                .build();
    }

    @Override
    public List<D> findAll() {
        return baseRepository.findAll().stream()
                .map(item -> modelMapper.map(item, dtoClass))
                .toList();
    }

    @Override
    public D findById(ID id) {
        T entity = baseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity Not found"));

        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public D save(D dto) {
        T entity = modelMapper.map(dto, entityClass);
        T saved = baseRepository.save(entity);
        return modelMapper.map(saved, dtoClass);
    }

    @Override
    public D update(ID id, D dto) {
        T existing = baseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity Not found"));

        modelMapper.map(dto, existing);
        T updated = baseRepository.save(existing);

        return modelMapper.map(updated, dtoClass);
    }

    @Override
    public void delete(ID id) {
        if (!baseRepository.existsById(id)) {
            throw new RuntimeException("Entity Not found");
        }
        baseRepository.deleteById(id);
    }
}
