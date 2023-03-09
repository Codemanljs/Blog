package com.ljs.blog.mapper;

import com.ljs.blog.pojo.User;

/**
 * @author ljs
 * @create 2023-03-09 15:21
 */
public interface SystemMapper {

     User selectOne(String username, String password);

     void insertUser(String username,String password,String tel);
}
