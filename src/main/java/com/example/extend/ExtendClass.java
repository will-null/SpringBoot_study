package com.example.extend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springboot
@Configuration
public class ExtendClass implements WebMvcConfigurer {

    //视图跳转---首页
    // alt+ins 查看要实现的方法
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("signIn");
    }
}
