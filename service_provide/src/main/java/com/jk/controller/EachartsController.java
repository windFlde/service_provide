package com.jk.controller;

import com.jk.bean.Echarts;
import com.jk.service.EachartsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EachartsController {

    @Resource
    private EachartsService eachartsService;

    @RequestMapping("queryEcharts")
    public HashMap<String, Object> queryEcharts() {

        HashMap<String, Object> param = new HashMap<>();
        ArrayList<Object> name = new ArrayList<>();
        ArrayList<Object> value = new ArrayList<>();
        List<Echarts> list=eachartsService.queryEcharts();
        for (Echarts echarts : list) {
            name.add(echarts.getName());
            value.add(echarts.getValue());
        }

        param.put("ename",name);
        param.put("evalue",value);
        return param;
    }

    @RequestMapping("queryEchartsTwo")
    public ArrayList<Echarts> queryEchartsTwo() {

       ArrayList<Echarts> user=eachartsService.queryEchartsTwo();
       return user;
    }
}
