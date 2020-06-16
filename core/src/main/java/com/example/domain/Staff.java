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
public class Staff {
    private Byte staffId;

    private String firstName;

    private String lastName;

    private Short addressId;

    private String email;

    private Byte storeId;

    private Boolean active;

    private String username;

    private String password;

    private Date lastUpdate;

    private byte[] picture;
}