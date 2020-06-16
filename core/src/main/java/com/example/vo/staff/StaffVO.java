package com.example.vo.staff;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询雇员信息
 */
@Getter
@Setter
@ToString
public class StaffVO implements Serializable {
    private Integer staffId;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean active;
    //head image
    private byte[] picture;
    //addr
    private Integer addressId;
    //
    private String address;

    private String district;

    private String postalCode;

    private String phone;
    //city
    private Integer cityId;

    private String city;
    //country
    private Integer countryId;

    private String country;
    //雇员修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;
}
