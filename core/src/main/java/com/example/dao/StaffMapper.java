package com.example.dao;

import com.example.domain.Staff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Byte staffId);

    int insert(Staff record);

    Staff selectByPrimaryKey(Byte staffId);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);
}