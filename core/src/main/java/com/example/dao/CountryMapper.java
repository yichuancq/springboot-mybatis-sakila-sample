package com.example.dao;

import com.example.domain.Country;

import java.util.List;

public interface CountryMapper {
    int deleteByPrimaryKey(Short countryId);

    int insert(Country record);

    Country selectByPrimaryKey(Short countryId);

    List<Country> selectAll();

    int updateByPrimaryKey(Country record);

    /**
     * 条件查询
     * @param country
     * @return
     */
    List<Country> selectByCondition(Country country);

    /**
     * @param country
     * @return
     */
    int selectTotalPage(Country country);
}