package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.application.CountryApplication;
import com.example.domain.Country;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CountryController {

    @Autowired
    private CountryApplication countryApplication;

    /**
     * @param country
     * @return
     */
    @ApiOperation(value = "/address/queryByPagCountryList", notes = "分页查询所有国家信息列表")
    @RequestMapping(value = "/address/queryByPagCountryList", method = RequestMethod.POST)
    public String queryByPagCountryList(@RequestBody Country country, PageRequest pageRequest) {
        try {
            log.info("country:{}", country.toString());
            log.info("pageRequest:{}", pageRequest.toString());
            return JSON.toJSONString(countryApplication.queryByPagCountryList(country, pageRequest));
        } catch (Exception ex) {
            ex.printStackTrace();
            return JSON.toJSONString(new ResultDTO(200, ex.getMessage(), 0, null));
        }
    }
}
