package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author yichuan
 */
@Getter
@Setter
@ToString
public class Language {
    private Byte languageId;

    private String name;

    private Date lastUpdate;
}