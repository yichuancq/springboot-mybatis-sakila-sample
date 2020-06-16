package com.example.dao;

import com.example.domain.Film;

import java.util.List;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    Film selectByPrimaryKey(Short filmId);

    List<Film> selectAll();

    int updateByPrimaryKey(Film record);
}