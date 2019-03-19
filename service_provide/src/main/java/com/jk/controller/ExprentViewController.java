package com.jk.controller;

import com.jk.bean.Baoming;
import com.jk.bean.DaKa;
import com.jk.bean.Guandian;
import com.jk.service.ExprentViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("query")
public class ExprentViewController {

    @Autowired
    ExprentViewService exprentViewService;




    @RequestMapping("ToPage")
    public String ToPage(String name){
        return name;
    }


    /*
     *           专家灼见 标题展示
     *
     * */
    @RequestMapping("querExprent")
    @ResponseBody
    public List<Guandian> querExprent(Guandian guandian){


        List<Guandian> list = exprentViewService.querExprent();


        return list;
    }


    @RequestMapping("querExprentList")
    @ResponseBody
    public Guandian querExprentList(Integer id){


        Guandian list1 = exprentViewService.querExprentList(id);


        return list1;
    }

    @RequestMapping("queryDjgd")
    public String ToPage( ){
        return "djgd";
    }

    /*查询大家观点*/
    @RequestMapping("queryGunadian")
    @ResponseBody
    public Guandian queryGunadian(Integer id) {

        Guandian guandian = exprentViewService.queryGunadian(id);
        return guandian;

    }

    @RequestMapping("queryLive")
    @ResponseBody
    public List<DaKa> queryLive() {

        List<DaKa> list=exprentViewService.queryLive();
        return list;
    }

    /**
     * 根据ID查询会议直播
     */
    @RequestMapping("queryZhibo")
    @ResponseBody
    public DaKa queryZhibo(Integer id) {

        DaKa DaKa = exprentViewService.queryZhibo(id);
        return DaKa;
    }

    @RequestMapping("addBaoming")
    @ResponseBody
    public String addBaoming(Baoming baoming) {

        exprentViewService.addBaoming(baoming);
        System.out.println(baoming);
        return "success";
    }

    @RequestMapping("queryZhiboTwo")
    @ResponseBody
    public DaKa queryZhiboTwo(Integer id) {

        DaKa daKa = exprentViewService.queryZhiboTwo(id);
        return daKa;
    }


    /**
     * 修改大咖在线观看人数
     * @param id
     * @return
     */
    @RequestMapping("updatePeople")
    @ResponseBody
    public String updatePeople(String id) {

        exprentViewService.updatePeople(id);
        return "success";
    }

    /**
     * 修改大家观点人数
     */
    @RequestMapping("updatePeopleTwo")
    @ResponseBody
    public String updatePeopleTwo(String id) {

        exprentViewService.updatePeopleTwo(id);
        return "success";
    }




}
