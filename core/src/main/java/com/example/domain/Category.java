package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Category {
    private Byte categoryId;

    private String name;

    private Date lastUpdate;

}