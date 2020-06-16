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
public class Rental {
    private Integer rentalId;

    private Date rentalDate;

    private Integer inventoryId;

    private Short customerId;

    private Date returnDate;

    private Byte staffId;

    private Date lastUpdate;

}