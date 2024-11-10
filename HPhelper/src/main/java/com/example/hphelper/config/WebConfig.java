package com.example.hphelper.config;

import com.example.hphelper.interceptors.LoginIterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIterceptor loginIterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //登录注册接口不拦截
        registry.addInterceptor(loginIterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
