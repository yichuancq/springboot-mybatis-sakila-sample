package com.example.dao;

import com.example.domain.CustomerList;

import java.util.List;

public interface CustomerListMapper {
    int insert(CustomerList record);

    List<CustomerList> selectAll();
}