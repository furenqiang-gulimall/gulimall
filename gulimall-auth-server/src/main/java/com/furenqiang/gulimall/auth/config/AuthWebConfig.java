package com.furenqiang.gulimall.auth.config;

import com.furenqiang.gulimall.auth.filiter.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthWebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

//        registry.addViewController("/index.html").setViewName("index");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //添加拦截器并，作用范围为所有请求
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
