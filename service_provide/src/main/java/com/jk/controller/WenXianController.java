package com.jk.controller;

import com.jk.bean.WenXian;
import com.jk.service.WenXianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("wenx")
public class WenXianController {

    @Resource
    private WenXianService wenXianService;

    @ResponseBody
    @RequestMapping("queryWenXIan")
    public List<WenXian> queryWenXIan() {
        List<WenXian> list = wenXianService.queryWenXIan();
        return list;
    }

    @ResponseBody
    @RequestMapping("updateBrowse")
    public String updateBrowse(WenXian wenXian) {
        wenXianService.updateBrowse(wenXian);
        return "1";
    }

    @ResponseBody
    @RequestMapping("queryXiangQing")
    public WenXian queryXiangQing(WenXian wenXian) {
        WenXian wx = wenXianService.queryXiangQing(wenXian);
        return wx;
    }

}
