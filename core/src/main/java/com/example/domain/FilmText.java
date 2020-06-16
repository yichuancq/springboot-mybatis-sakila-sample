package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FilmText {
    private Short filmId;

    private String title;

    private String description;
}