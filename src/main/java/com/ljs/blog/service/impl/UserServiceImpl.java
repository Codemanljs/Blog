package com.ljs.blog.service.impl;

import com.ljs.blog.mapper.UserMapper;
import com.ljs.blog.pojo.User;
import com.ljs.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ljs
 * @create 2023-03-10 10:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void updateInfo(User user) {
        userMapper.updateUserInfo(user.getUserId(),user.getUsername(),user.getPassword(),user.getTel());

    }
}
