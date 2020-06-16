package com.example.service.city;

import com.example.domain.City;

import java.util.List;

/**
 * @author yichuan
 */
public interface CityService {
    /**
     * save city
     *
     * @param city
     * @return
     */
    Integer saveOne(City city);



    City findOneById(Short cityId);

    /**
     * 分页查询
     *
     * @param city
     * @return
     */
    List<City> selectByPage(City city);

    /**
     * 获取总页数
     *
     * @param city
     * @return
     */
    Integer totalPage(City city);

}
