package com.example.service;

import com.example.domain.Products;
import com.example.dto.PageRequestDto;
import com.example.dto.PageResultDto;
import com.example.dto.ProductsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductsServiceTest {

    @Autowired
    private ProductsService productsService;

    @Test
    public void register() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            ProductsDto productsDto = ProductsDto.builder()
                    .prodNm("상품" + i + "입니다.")
                    .price(200000 + i)
                    .period(LocalDate.now())
                    .prodContent("안녕하세요 상품" + i + "입니다. 어떠십니까? 하하하")
                    .build();
            System.out.println(productsService.register(productsDto));
        });

    }

    @Test
    public void List() {

        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).build();
        PageResultDto<ProductsDto, Products> pageResultDto = productsService.getList(pageRequestDto);

//        for (ProductsDto productsDto : pageResultDto.getDtoList()) {
//            System.out.println(productsDto);
//        }
        System.out.println(pageResultDto);
    }

}