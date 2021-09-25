package com.xdemo.auth.Utils;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResponseData<T> implements Serializable {
    private String code;

    private String msg;

    private T data;


    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(ResultEnum ResultEnum) {
        this.code = ResultEnum.getCode();
        this.msg = ResultEnum.getMsg();
    }

    public ResponseData(ResultEnum ResultEnum, T data) {
        this.code = ResultEnum.getCode();
        this.msg = ResultEnum.getMsg();
        this.data = data;
    }

    public ResponseData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
