package com.example.domain.address;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Address {
    private Short addressId;

    private String address;

    private String address2;

    private String district;

    private Short cityId;

    private String postalCode;

    private String phone;

    private Date lastUpdate;
    //GeoPoint 地理坐标
    private String location;
}