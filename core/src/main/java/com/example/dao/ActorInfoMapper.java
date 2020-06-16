package com.example.dao;

import com.example.domain.ActorInfo;

import java.util.List;

public interface ActorInfoMapper {
//    int insert(ActorInfo record);

    List<ActorInfo> selectAll();
}