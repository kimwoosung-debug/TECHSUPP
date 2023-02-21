package com.example.service;

import com.example.domain.Products;
import com.example.dto.PageRequestDto;
import com.example.dto.PageResultDto;
import com.example.dto.ProductsDto;
import com.example.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public Long register(ProductsDto productsDto) {

        Products entity = dtoToEntity(productsDto);
        productsRepository.save(entity);

        return entity.getId();
    }

    @Override
    public PageResultDto<ProductsDto, Products> getList(PageRequestDto pageRequestDto) {

        Pageable pageable = pageRequestDto.getPageable(Sort.by("id").descending());
        Page<Products> result = productsRepository.findAll(pageable);
        Function<Products, ProductsDto> fn = (entity -> entityToDto(entity));

        return new PageResultDto<>(result, fn);
    }
}
