package com.example.application;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.service.city.CityService;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityApplication {


    @Autowired
    private CityService cityService;

    /**
     * @param city
     * @param pageRequest
     * @return
     */
    public ResultDTO<Country> queryByPageCityList(City city, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNumber(), pageRequest.getPageSize());
        List<City> filmLists = cityService.selectByPage(city);
        Integer totalPage = cityService.totalPage(city);
        return new ResultDTO(200, "ok", totalPage, filmLists);

    }

}
