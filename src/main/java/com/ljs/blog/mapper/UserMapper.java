package com.ljs.blog.mapper;

/**
 * @author ljs
 * @create 2023-03-10 10:13
 */
public interface UserMapper {


    void updateUserInfo(Integer userId, String username, String password, String tel);
}
