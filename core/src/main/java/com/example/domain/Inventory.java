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
public class Inventory {
    private Integer inventoryId;

    private Short filmId;

    private Byte storeId;

    private Date lastUpdate;

}