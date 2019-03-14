package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.General;
import com.jk.bean.Oder;
import com.jk.bean.User;
import com.jk.service.PatientService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PatientController {

    @Resource
    private PatientService patientService;

    @Resource
    AmqpTemplate amqpTemplate;

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

   /* @RequestMapping("addShoucang")
    public String addShoucang(General general,HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user != null) {

            patientService.addShoucang(general);
            return "1";


        }else{

            return "0";
        }





    }*/

    @RequestMapping("fsYouxiang")
    public void fsYouxiang(String id,String username,String email) {
        if (username != null) {
            Oder oder = patientService.fsYouxiang(id);
            oder.setUsername(username);
            oder.setEmail(email);
            //将对象转换为json串
            String orderJson = JSON.toJSONString(oder);
            // 往消息队列推送消息
            amqpTemplate.convertAndSend("1807B-01", orderJson);
            System.out.println("消息已发送");

        }

    }

    /*修改教育视频观看人数*/
    @RequestMapping("updatePeople")
    public String updatePeople(General general) {

        patientService.updatePeople(general);
        return "success";
    }


}
