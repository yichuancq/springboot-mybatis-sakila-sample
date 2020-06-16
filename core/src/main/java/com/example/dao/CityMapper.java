package com.example.dao;

import com.example.domain.City;

import java.util.List;

public interface CityMapper {

    int deleteByPrimaryKey(Short cityId);

    int insert(City record);

    City selectByPrimaryKey(Short cityId);

    List<City> selectAll();

    int updateByPrimaryKey(City record);

    /**
     * 条件查询
     *
     * @param city
     * @return
     */
    List<City> selectByCondition(City city);

    /**
     * @param city
     * @return
     */
    int selectTotalPage(City city);

}