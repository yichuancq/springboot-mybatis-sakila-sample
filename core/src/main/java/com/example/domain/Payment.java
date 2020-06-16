package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yichuan
 */
@Getter
@Setter
@ToString
public class Payment {
    private Short paymentId;

    private Short customerId;

    private Byte staffId;

    private Integer rentalId;

    private BigDecimal amount;

    private Date paymentDate;

    private Date lastUpdate;

}