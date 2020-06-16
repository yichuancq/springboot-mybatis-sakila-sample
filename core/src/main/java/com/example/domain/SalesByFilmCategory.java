package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SalesByFilmCategory {
    private String category;

    private BigDecimal totalSales;

}