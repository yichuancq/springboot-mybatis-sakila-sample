package com.example.dao;

import com.example.domain.SalesByStore;

import java.util.List;

public interface SalesByStoreMapper {
    int insert(SalesByStore record);

    List<SalesByStore> selectAll();
}