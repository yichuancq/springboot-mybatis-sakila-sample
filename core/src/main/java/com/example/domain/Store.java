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
public class Store {
    private Byte storeId;

    private Byte managerStaffId;

    private Short addressId;

    private Date lastUpdate;
}