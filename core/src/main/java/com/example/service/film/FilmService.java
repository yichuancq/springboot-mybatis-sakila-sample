package com.example.service.film;

import com.example.domain.FilmList;

import java.util.List;

/**
 * @author yichuan
 */
public interface FilmService {

    /**
     * @return
     */
    List<FilmList> selectAll();

    /**
     * @param filmList
     * @return
     */
    List<FilmList> selectByPage(FilmList filmList);

    /**
     *
     * @param filmList
     * @return
     */
    Integer totalPage(FilmList filmList);

}
