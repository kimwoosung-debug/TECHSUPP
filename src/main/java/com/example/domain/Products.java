package com.example.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;
    @Column(length = 255, nullable = false)
    private String prodNm;
    @Lob
    @Column(nullable = false)
    private String prodContent;
    @Column(nullable = false)
    private int price;

    private LocalDate period;

    @Column(columnDefinition = "double default 0.0", nullable = false)
    private double percent;

    @Enumerated(EnumType.STRING)
    private ProductCheck prodCheck;

    @Enumerated(EnumType.STRING)
    private ProductStatus prodStatus;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;
}
