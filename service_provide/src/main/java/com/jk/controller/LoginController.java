package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.User;
import com.jk.service.LoginService;
import com.jk.service.PhoneLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private PhoneLoginService phoneLoginService;

    @ResponseBody
    @RequestMapping("toLogin")
    public String toLogin(User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        User userFromDB=loginService.toLogin(user);
        if (userFromDB==null) {
            return "1";
        }
        session.setAttribute("user",userFromDB);
        Integer blackUser=phoneLoginService.queryUserBlack(userFromDB.getId());
        if (blackUser>=1) {
            return "blackUser";
        }

        //正确
        //判断有没有记住密码
        if (user.getRemempwd()!=null) {
            String jsonString = JSONObject.toJSONString(user);
            String encode = null;
            //捕捉异常
                try {
                    encode = URLEncoder.encode(jsonString, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            Cookie pwd = new Cookie("pwd",encode);

            pwd.setMaxAge(410381);
            pwd.setPath("/");
            response.addCookie(pwd);

            /* 将用户的用户名称存放到cookie中 - start*/
//            Cookie userName=new Cookie(Constant.userName,userFromDB.getUsername());
//            userName.setMaxAge(410381);
//            userName.setPath("/");
//            response.addCookie(userName);
            /*将用户的用户名称存放到cookie中 end*/
        }else {
            Cookie cc = new Cookie("pwd", "");
            cc.setMaxAge(0);
            cc.setPath("/");
            response.addCookie(cc);
        }
        return "2";

    }

    @ResponseBody
    @RequestMapping("removeUser")
    public String removeUser(HttpSession session) {
        session.removeAttribute("user");
        return "";
    }

    @ResponseBody
    @RequestMapping("toLoginByQQ")
    public void toLoginByQQ(HttpSession session,String openId) {
        User userFormDB = loginService.toLoginByQQ(openId);
        session.setAttribute("user",userFormDB);
    }


}
