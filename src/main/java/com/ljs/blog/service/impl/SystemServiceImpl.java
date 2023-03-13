package com.ljs.blog.service.impl;

import com.ljs.blog.mapper.SystemMapper;
import com.ljs.blog.pojo.User;
import com.ljs.blog.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ljs
 * @create 2023-03-09 14:56
 */
@Service(value = "systemService")
public class SystemServiceImpl implements SystemService {

    @Resource
    SystemMapper systemMapper;

    @Override
    public User selectOne(String username, String password) {
        User user = systemMapper.selectOne(username, password);
        return user;
    }

    @Override
    public void insertUser(String username, String password, String tel) {
        systemMapper.insertUser(username,password,tel);
    }


}
