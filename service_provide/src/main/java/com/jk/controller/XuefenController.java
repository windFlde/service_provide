package com.jk.controller;

import com.jk.bean.Xuefen;
import com.jk.service.XuefenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class XuefenController {

    @Resource
    private XuefenService xuefenService;

    @RequestMapping("queryXuefen")
    public List<Xuefen> queryXuefen() {

        List<Xuefen> list = xuefenService.queryXuefen();
        return list;
    }

   /* @RequestMapping("queryXuefenTwo")
    public List<Xuefen> queryXuefenTwo(Xuefen xuefen) {

        List<Xuefen> list = xuefenService.queryXuefenTwo(xuefen);
        return list;

    }*/

}
