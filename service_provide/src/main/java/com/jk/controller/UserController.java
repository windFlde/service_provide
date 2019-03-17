package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("registerForm")
    public String registerForm(User user) {
        userService.registerForm(user);
        return "";
    }

}
