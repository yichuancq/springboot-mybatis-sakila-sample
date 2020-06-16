package com.example.dao;

import com.example.domain.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Byte categoryId);

    int insert(Category record);

    Category selectByPrimaryKey(Byte categoryId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}