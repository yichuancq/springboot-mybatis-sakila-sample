package com.example.dao;

import com.example.domain.FilmList;

import java.util.List;

public interface FilmListMapper {
    int insert(FilmList record);

    /**
     * 查询所有
     * @return
     */
    List<FilmList> selectAll();

    /**
     * 条件查询
     * @param filmList
     * @return
     */
    List<FilmList> selectByCondition(FilmList filmList);

    /**
     * 获取总页码
     *
     * @param filmList
     * @return
     */
    Integer totalPage(FilmList filmList);
}