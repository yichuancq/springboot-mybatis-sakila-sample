package com.example.dao;

import com.example.domain.NicerButSlowerFilmList;

import java.util.List;

public interface NicerButSlowerFilmListMapper {
    int insert(NicerButSlowerFilmList record);

    List<NicerButSlowerFilmList> selectAll();
}