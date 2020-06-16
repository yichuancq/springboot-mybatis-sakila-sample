package com.example.dao;

import com.example.domain.FilmText;

import java.util.List;

public interface FilmTextMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(FilmText record);

    FilmText selectByPrimaryKey(Short filmId);

    List<FilmText> selectAll();

    int updateByPrimaryKey(FilmText record);
}