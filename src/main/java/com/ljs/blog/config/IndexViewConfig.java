package com.ljs.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ljs
 * @create 2023-03-10 15:22
 */
@Configuration
public class IndexViewConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置访问路径为 “/” 跳转到指定页面
        registry.addViewController("/login").setViewName("forward:/login.html");
        //设置为最高优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
