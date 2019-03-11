package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ResponseBody
    @RequestMapping("toLogin")
    public String toLogin(User users, HttpSession session) {
        User user=loginService.toLogin(users);
        if (user!=null) {
            session.setAttribute("user",user);
            return "1";
        }else{
            return "2";
        }

    }

    @ResponseBody
    @RequestMapping("removeUser")
    public String removeUser(HttpSession session) {
        session.invalidate();
        return "";
    }

}
