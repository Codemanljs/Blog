package com.ljs.blog.utils;

import lombok.Getter;

/**
 * @author ljs
 * @create 2023-03-09 9:28
 */
@Getter
public enum ResultEnum {

    SUCCESS(200,"成功"),
    FAIL(201,"失败"),
    NOTFOUND(404,"没找到"),
    ILLEGAL_REQUEST( 204, "非法请求"),
    LOGIN_ERROR(207, "用户名或密码错误"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
