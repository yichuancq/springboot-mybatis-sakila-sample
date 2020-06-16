package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yichuan
 */
@Getter
@Setter
@ToString
public class StaffList {
    private Byte id;

    private String name;

    private String address;

    private String zipCode;

    private String phone;

    private String city;

    private String country;

    private Byte sid;

}