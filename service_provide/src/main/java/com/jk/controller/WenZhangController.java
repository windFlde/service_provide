package com.jk.controller;

import com.jk.bean.WenZhang;
import com.jk.service.WenZHangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("wenz")
public class
WenZhangController {

    @Resource
    private WenZHangService wenZHangService;

    //wuyong

    @ResponseBody
    @RequestMapping("queryWen")
    public WenZhang queryWen(WenZhang wenZhang) {
        WenZhang wen = wenZHangService.queryWen(wenZhang);
        return wen;
    }

    @RequestMapping("toView")
    public String toView(String viewName) {
        return viewName;
    }

    @ResponseBody
    @RequestMapping("setTitleVal")
    public String setTitleVal(HttpSession session, WenZhang wenZhang) {
        session.setAttribute("wenZhang", wenZhang);
        return "";
    }

}
