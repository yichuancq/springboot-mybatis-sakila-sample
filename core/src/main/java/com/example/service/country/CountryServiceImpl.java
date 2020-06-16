package com.example.service.country;

import com.example.dao.CountryMapper;
import com.example.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;


    @Override
    public Integer saveOne(Country country) {
        return countryMapper.insert(country);
    }

    @Override
    public List<Country> findByCondition(Country country) {
        return null;
    }

    /**
     * @param countryId
     * @return
     */
    @Override
    public Country findById(Short countryId) {

        return countryMapper.selectByPrimaryKey(countryId);
    }

    /**
     * @param country
     * @return
     */
    @Override
    public List<Country> selectByPage(Country country) {
        return countryMapper.selectByCondition(country);
    }

    /**
     * @param country
     * @return
     */
    @Override
    public Integer totalPage(Country country) {
        return countryMapper.selectTotalPage(country);
    }
}
