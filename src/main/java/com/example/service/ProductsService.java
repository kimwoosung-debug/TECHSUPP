package com.example.service;

import com.example.domain.Products;
import com.example.dto.PageRequestDto;
import com.example.dto.PageResultDto;
import com.example.dto.ProductsDto;
import com.example.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ProductsService {

    Long register(ProductsDto productsDto);

    PageResultDto<ProductsDto, Products> getList(PageRequestDto pageRequestDto);

    default Products dtoToEntity(ProductsDto productsDto) {
        Products entity = Products.builder()
                .id(productsDto.getId())
                .prodNm(productsDto.getProdNm())
                .price(productsDto.getPrice())
                .period(productsDto.getPeriod())
                .prodContent(productsDto.getProdContent()).build();

        return entity;
    }

    default ProductsDto entityToDto(Products entity) {

        ProductsDto dto = ProductsDto.builder()
                .id(entity.getId())
                .prodNm(entity.getProdNm())
                .price(entity.getPrice())
                .percent(entity.getPercent())
                .prodStatus(entity.getProdStatus())
                .prodCheck(entity.getProdCheck())
                .view(entity.getView()).build();

        return dto;
    }
}
