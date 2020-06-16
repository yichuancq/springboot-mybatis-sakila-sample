package com.example.dao;

import com.example.domain.address.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Short addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Short addressId);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}