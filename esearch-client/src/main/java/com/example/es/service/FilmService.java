package com.example.es.service;

import com.example.es.domain.FilmList;

import java.util.List;

public interface FilmService {


    /**
     * @param filmList
     * @return
     */
    List<FilmList> selectByPage(FilmList filmList);


}
