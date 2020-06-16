package com.example.dao;

import com.example.domain.Actor;

import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Short actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);
}