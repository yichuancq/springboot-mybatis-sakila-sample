package com.example.es.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yichuan
 */
@Getter
@Setter
@ToString
@Document(indexName = "nicer_but_slower_film_list", type = "gzdc")
public class FilmList implements Serializable {
    @Id
    private String id;

    @Field(type = FieldType.Short, name = "FID")
    private Short fid;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String category;

    @Field(type = FieldType.Auto)
    private BigDecimal price;

    @Field(type = FieldType.Short)
    private Short length;

    @Field(type = FieldType.Text)
    private String rating;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    //@Field(type = FieldType.Text,analyzer = "ik_max_word" ,searchAnalyzer="ik_max_word")
    private String actors;

}
