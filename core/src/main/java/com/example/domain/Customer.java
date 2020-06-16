package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Customer {
    private Short customerId;

    private Byte storeId;

    private String firstName;

    private String lastName;

    private String email;

    private Short addressId;

    private Boolean active;

    private Date createDate;

    private Date lastUpdate;
}