package com.ljs.blog.utils;

import lombok.Data;

/**
 * @author ljs
 * @create 2023-03-09 9:16
 */
@Data
public class Result<T> {
    //状态码
    private Integer code;

    //返回信息
    private String message;

    //返回数据
    private T data;


    //返回数据方法
    public static<T> Result<T> build(T data){
        Result<T> result = new Result<T>();
        result.setData(data);
        return result;
    }

    //响应成功方法,携带数据
    public static<T> Result ok(T data){
        Result<T> result = new Result<>();
        result.build(data);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }
    //响应成功不携带数据
    public static<T> Result ok(){
        Result<T> result = new Result<>();
        return result.ok(null);
    }


    //响应失败方法，携带数据
    public static<T> Result fail(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMessage(ResultEnum.FAIL.getMessage());
        return result;
    }

    //响应失败不携带数据
    public static<T> Result fail(){
        Result<T> result = new Result<>();
        return result.fail(null);
    }

    //返回携带信息方法
    public Result message(String str){
        Result<T> result = new Result<>();
        result.setMessage(str);
        return result;
    }




}
