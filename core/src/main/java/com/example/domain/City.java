package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class City implements Serializable {

    private Short cityId;

    private String city;

    private Short countryId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;
}