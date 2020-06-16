package com.example.dao;

import com.example.domain.FilmActor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmActorMapper {
    int deleteByPrimaryKey(@Param("actorId") Short actorId, @Param("filmId") Short filmId);

    int insert(FilmActor record);

    FilmActor selectByPrimaryKey(@Param("actorId") Short actorId, @Param("filmId") Short filmId);

    List<FilmActor> selectAll();

    int updateByPrimaryKey(FilmActor record);
}