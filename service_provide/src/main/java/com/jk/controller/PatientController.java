package com.jk.controller;

import com.jk.bean.General;
import com.jk.service.PatientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PatientController {

    @Resource
    private PatientService patientService;

    @RequestMapping("queryVideo")
    public List<General> queryVideo() {

        List<General> list=patientService.queryVideo();
        return list;
    }

    @RequestMapping("queryManual")
    public List<General> queryManual() {

        List<General> list=patientService.queryManual();
        return list;
    }

    @RequestMapping("queryHuanzejiaoyu")
    public General queryHuanzejiaoyu(Integer id) {

        General general = patientService.queryHuanzejiaoyu(id);
        return general;
    }

    @RequestMapping("queryHuanzheTree")
    public General queryHuanzheTree(Integer id) {

        General general = patientService.queryHuanzheTree(id);
        return general;
    }


}
