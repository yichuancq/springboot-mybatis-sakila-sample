package com.example.service.country;

import com.example.domain.Country;

import java.util.List;

public interface CountryService {
    /**
     * save one
     *
     * @param country
     * @return
     */
    Integer saveOne(Country country);

    /**
     * findByCondition
     *
     * @param country
     * @return
     */
    List<Country> findByCondition(Country country);

    /**
     * findById
     *
     * @param countryId
     * @return
     */
    Country findById(Short countryId);


    /**分页查询
     * @param country
     * @return
     */
    List<Country> selectByPage(Country country);

    /**获取总页数
     * @param country
     * @return
     */
    Integer totalPage(Country country);


}
