package com.example.es.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 返回结果结构
 *
 * @param <T>
 */
@Data
@Getter
@Setter
@ToString
public class ResultDTO<T> implements Serializable {
    private Integer code = 0;
    private String msg = "";
    private Integer totalPage = 0;
    private T data;

    public ResultDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.totalPage = totalPage;
        this.data = data;
    }

    /**
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public  ResultDTO of(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.totalPage = totalPage;
        this.data = data;
        return  this;
    }
    public ResultDTO(int code, String msg, int totalPage, T data) {
        this.code = code;
        this.msg = msg;
        this.totalPage = totalPage;
        this.data = data;
    }

}
