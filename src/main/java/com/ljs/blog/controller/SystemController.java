package com.ljs.blog.controller;

import com.ljs.blog.pojo.LoginForm;
import com.ljs.blog.pojo.RegisterForm;
import com.ljs.blog.pojo.User;
import com.ljs.blog.service.SystemService;
import com.ljs.blog.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljs
 * @create 2023-03-09 9:39
 */
@RestController("/blog")
public class SystemController {

    @Autowired
    SystemService systemService;

    //登录功能
    @GetMapping("/login")
    public Result login(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

            User user=systemService.selectOne(username,password);
            if (user==null){
                return Result.fail().message("用户不存在!");
            }else {
                if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())){
                    return Result.fail().message("用户名或密码错误!请重新登录!");
                }
            }
            return Result.ok();
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
