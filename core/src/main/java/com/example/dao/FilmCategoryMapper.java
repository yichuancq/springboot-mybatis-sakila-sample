package com.example.dao;

import com.example.domain.FilmCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmCategoryMapper {
    int deleteByPrimaryKey(@Param("filmId") Short filmId, @Param("categoryId") Byte categoryId);

    int insert(FilmCategory record);

    FilmCategory selectByPrimaryKey(@Param("filmId") Short filmId, @Param("categoryId") Byte categoryId);

    List<FilmCategory> selectAll();

    int updateByPrimaryKey(FilmCategory record);
}