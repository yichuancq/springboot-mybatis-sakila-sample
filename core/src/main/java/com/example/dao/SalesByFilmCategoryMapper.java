package com.example.dao;

import com.example.domain.SalesByFilmCategory;

import java.util.List;

public interface SalesByFilmCategoryMapper {
    int insert(SalesByFilmCategory record);

    List<SalesByFilmCategory> selectAll();
}