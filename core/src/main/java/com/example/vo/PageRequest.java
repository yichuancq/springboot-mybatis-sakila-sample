package com.example.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Data
public class PageRequest implements Serializable {
    private Integer pageNumber = 0;
    private Integer pageSize = 20;

    public PageRequest() {
    }

    public PageRequest(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
