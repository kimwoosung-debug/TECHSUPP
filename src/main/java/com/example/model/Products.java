package com.example.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Products {

    private final Long id;
    private final String name;
    private final String content;
    private final String price;
    private final LocalDateTime period;
    private final LocalDateTime date;
    private final boolean check;
}
