package com.example.dto;

import com.example.domain.ProductCheck;
import com.example.domain.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductsDto {

    private Long id;
    private String prodNm;
    private String prodContent;
    private int price;
    private LocalDate period;
    private double percent;
    private ProductStatus prodStatus;
    private ProductCheck prodCheck;
    private int view;
}
