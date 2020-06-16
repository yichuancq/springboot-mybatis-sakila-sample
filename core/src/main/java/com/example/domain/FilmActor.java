package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class FilmActor {
    private Short actorId;

    private Short filmId;

    private Date lastUpdate;

}