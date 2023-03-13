package com.ljs.blog.controller;

import com.ljs.blog.pojo.User;
import com.ljs.blog.service.UserService;
import com.ljs.blog.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ljs
 * @create 2023-03-09 9:40
 *
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    //修改个人信息
    @PostMapping("/updateInfo/")
    public Result updateMyInfo(@RequestBody User user){
        userService.updateInfo(user);
        return Result.ok();
    }





}
