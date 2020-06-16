package com.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yichuan
 */
@Getter
@Setter
@ToString
@Data
public class FilmList implements Serializable {
    private Short fid;

    private String title;

    private String category;

    private BigDecimal price;

    private Short length;

    private String rating;

    private String description;

    private String actors;

}