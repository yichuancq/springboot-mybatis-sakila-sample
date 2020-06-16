package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.application.CityApplication;
import com.example.domain.City;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CityController {


    @Autowired
    private CityApplication cityApplication;

    /**
     * @param city
     * @return
     */
    @ApiOperation(value = "/address/queryByPagCityList", notes = "分页查询所有城市信息列表")
    @RequestMapping(value = "/address/queryByPagCityList", method = RequestMethod.POST)
    public String queryByPagCityList(@RequestBody City city, PageRequest pageRequest) {
        try {
            log.info("city:{}", city.toString());
            log.info("pageRequest:{}", pageRequest.toString());
            return JSON.toJSONString(cityApplication.queryByPageCityList(city, pageRequest));
        } catch (Exception ex) {
            ex.printStackTrace();
            return JSON.toJSONString(new ResultDTO(200, ex.getMessage(), 0, null));
        }
    }

}
