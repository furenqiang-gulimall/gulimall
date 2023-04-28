package com.furenqiang.gulimall.ssoclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Value("${sso.server}")
    private String ssoServer;

//    @ResponseBody
    @GetMapping("hello")
    public String hello(HttpServletRequest request){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(null==loginUser){
            return "redirect:"+ssoServer+"?redirect_url=http://furenqiang1.com:8080/hello";
        }
        return "hello";
    }
}
