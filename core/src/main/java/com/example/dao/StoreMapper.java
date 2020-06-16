package com.example.dao;

import com.example.domain.Store;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Byte storeId);

    int insert(Store record);

    Store selectByPrimaryKey(Byte storeId);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}