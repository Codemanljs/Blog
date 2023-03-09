package com.ljs.blog.service;

import com.ljs.blog.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author ljs
 * @create 2023-03-09 11:03
 */
public interface SystemService {

    User selectOne(String username, String password);


    void insertUser(String username, String password,String tel);
}
