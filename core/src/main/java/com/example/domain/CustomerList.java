package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerList {
    private Short id;

    private String name;

    private String address;

    private String zipCode;

    private String phone;

    private String city;

    private String country;

    private String notes;

    private Byte sid;
}