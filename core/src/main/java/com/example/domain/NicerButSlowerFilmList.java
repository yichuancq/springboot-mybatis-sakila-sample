package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class NicerButSlowerFilmList {
    private Short fid;

    private String title;

    private String category;

    private BigDecimal price;

    private Short length;

    private String rating;

    private String description;

    private String actors;
}