package com.example.application;

import com.example.domain.Country;
import com.example.service.country.CountryService;
import com.example.vo.PageRequest;
import com.example.vo.ResultDTO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryApplication {

    @Autowired
    private CountryService countryService;

    /**
     * @param country
     * @param pageRequest
     * @return
     */
    public ResultDTO<Country> queryByPagCountryList(Country country, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNumber(), pageRequest.getPageSize());
        List<Country> filmLists = countryService.selectByPage(country);
        Integer totalPage = countryService.totalPage(country);
        return new ResultDTO(200, "ok", totalPage, filmLists);

    }


}
