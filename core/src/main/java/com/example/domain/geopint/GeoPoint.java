package com.example.domain.geopint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class GeoPoint {
    private String type = "";

    public GeoPoint(BigDecimal lng, BigDecimal lat) {
        this.lng = lng;
        this.lat = lat;
    }

    /* 经度 */
    private BigDecimal lng;
    /* 纬度 */
    private BigDecimal lat;

}
