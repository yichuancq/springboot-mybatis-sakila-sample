package com.example.dao;

import com.example.domain.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Short customerId);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}