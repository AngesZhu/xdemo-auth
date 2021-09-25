package com.xdemo.auth.Utils;

public class ResponseDataUtil {
    /**
     * 带实体的统一返回
     *
     * @param data 实体
     * @param <T>  实体类型
     * @return
     */
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResultEnum.SUCCESS, data);
    }

    public static ResponseData buildSuccess() {
        return new ResponseData(ResultEnum.SUCCESS);
    }

    public static ResponseData buildSuccess(String msg) {
        return new ResponseData(ResultEnum.SUCCESS.getCode(), msg);
    }

    public static ResponseData buildSuccess(String code, String msg) {
        return new ResponseData(code, msg);
    }

    public static <T> ResponseData buildSuccess(String msg, T data) {
        return new ResponseData<T>(ResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseData buildSuccess(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }

    public static ResponseData buildSuccess(ResultEnum ResultEnum) {
        return new ResponseData(ResultEnum);
    }

    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResultEnum.ERROR, data);
    }

    public static ResponseData buildError() {
        return new ResponseData(ResultEnum.ERROR);
    }

    public static ResponseData buildError(String msg) {
        return new ResponseData(ResultEnum.ERROR.getCode(), msg);
    }

    public static ResponseData buildError(String code, String msg) {
        return new ResponseData(code, msg);
    }

    public static <T> ResponseData buildError(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }

    public static ResponseData buildError(ResultEnum ResultEnum) {
        return new ResponseData(ResultEnum);
    }

}
