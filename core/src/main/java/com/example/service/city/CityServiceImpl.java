package com.example.service.city;

import com.example.dao.CityMapper;
import com.example.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yichuan
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;


    @Override
    public Integer saveOne(City city) {
        return cityMapper.insert(city);
    }



    @Override
    public City findOneById(Short cityId) {
        return cityMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public List<City> selectByPage(City city) {

        return cityMapper.selectByCondition(city);
    }

    @Override
    public Integer totalPage(City city) {
        return cityMapper.selectTotalPage(city);

    }
}
