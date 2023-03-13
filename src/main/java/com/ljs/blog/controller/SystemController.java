package com.ljs.blog.controller;

import com.ljs.blog.pojo.LoginForm;
import com.ljs.blog.pojo.RegisterForm;
import com.ljs.blog.pojo.User;
import com.ljs.blog.service.SystemService;
import com.ljs.blog.utils.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ljs
 * @create 2023-03-09 9:39
 */
@RestController("/blog")
public class SystemController {

    @Resource
    SystemService systemService;


    //登录功能
    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        User user=systemService.selectOne(username,password);
        if (user!=null){
            if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())){
                return Result.fail().message("用户名或密码错误!请重新登录!");
            }else {
                Integer userId = user.getUserId();
                String token = JwtHelper.createToken(userId, username, password);
                RedisUtil.set("token",token);
                return Result.ok(token);
            }
        }else {
            return Result.fail().message("用户不存在!");
        }
    }


    //注册功能
    @PostMapping("/register")
    public Result register(RegisterForm registerForm){
        Integer smsCode = registerForm.getSmsCode();
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();
        String tel = registerForm.getTel();
        String code = RedisUtil.get("code");
        if (smsCode.equals(code)){
            return Result.fail().message("验证码错误!请重新验证");
        }else {
            systemService.insertUser(username,password,tel);
            return Result.ok();
        }

    }

    //短信功能
    @GetMapping("/message")
    public Result sendSms(String tel){
        if (StringUtils.isEmpty(tel) || TelUtil.isValidPhoneNumber(tel)){
            return Result.fail().message("电话号码错误!请重新输入!");
        }else {
            String code = MessageUtil.creatSms();
            SMSUtils.sendMessage("盘古广告","SMS_204255313",tel,code);
            RedisUtil.set("code",code);
            return Result.ok();
        }
    }

}
