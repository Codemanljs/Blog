package com.ljs.blog.pojo;

import lombok.Data;

/**
 * @author ljs
 * @create 2023-03-09 15:44
 */
@Data
public class RegisterForm {

    private String username;

    private String password;

    private String tel;

    private Integer smsCode;

}
