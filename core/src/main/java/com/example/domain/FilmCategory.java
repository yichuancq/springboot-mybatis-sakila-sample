package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class FilmCategory {
    private Short filmId;

    private Byte categoryId;

    private Date lastUpdate;
}