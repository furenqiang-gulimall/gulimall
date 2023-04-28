package com.furenqiang.gulimall.auth.controller;

import com.furenqiang.gulimall.auth.filiter.MyInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/index.html")
    public String index(String redirect_url,Model model){
        Object o = MyInterceptor.objectThreadLocal.get();
        MyInterceptor.objectThreadLocal.set("yourEntity");
        model.addAttribute("url",redirect_url);
            return "index";
    }

    @GetMapping("/login.html")
    public String loginPage(String account, String password,String redirect_url, Model model, HttpServletRequest request){
        if(account!=null&&!"".equals(account)){
            if(redirect_url!=null&& !StringUtils.isEmpty(redirect_url)){
                return "redirect:"+redirect_url;
            }
            model.addAttribute("msg","login success!");
            return "login";
        }else{
            return "index";
        }
    }
}
