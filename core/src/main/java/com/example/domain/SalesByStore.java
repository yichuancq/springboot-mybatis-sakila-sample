package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SalesByStore {
    private String store;

    private String manager;

    private BigDecimal totalSales;

}