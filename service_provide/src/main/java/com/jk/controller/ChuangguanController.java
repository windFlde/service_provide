package com.jk.controller;

import com.jk.bean.Answer;
import com.jk.bean.User;
import com.jk.service.ChuangguanService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChuangguanController {

    @Resource
    private ChuangguanService chuangguanService;

    @Resource
    MongoTemplate mongoTemplate;

    @RequestMapping("queryChuangguan")
    public List<User> queryChuangguan() {

        List<User> list=chuangguanService.queryChuangguan();
        return list;


    }

    @ResponseBody
    @RequestMapping("findItme")
    public List<Answer> findItme() {

        List<Answer> find = mongoTemplate.find(null, Answer.class);
        return find;
    }

    @ResponseBody
    @RequestMapping("insertItme")
    public String insertItme(Answer answer) {

        answer.setId(3);
        answer.setContent("三甲医院,私立医院,社区服务中心");
        answer.setTitle("您所在的医疗机构是");
        mongoTemplate.insert(answer);
        System.out.println(answer);
        return "success";
    }

    @RequestMapping("deleteItem")
    @ResponseBody
    public String deleteItem(String id) {


        mongoTemplate.remove(id);
        return "success";
    }

    @RequestMapping("upateCount")
    public String upateCount(User user) {

        chuangguanService.upateCount(user);
        return "success";
    }





}
