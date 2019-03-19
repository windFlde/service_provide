package com.jk.controller;

import com.jk.bean.Answer;
import com.jk.bean.User;
import com.jk.service.ChuangguanService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

        answer.setId(9);
        answer.setContent("主任医师,住院医师,副主任医师,实习医生,在校院生,其他");
        answer.setTitle("您现在的职称是");
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

    @RequestMapping("AddAnswer")
    @ResponseBody
    public int AddAnswer(Answer answer) {

        ArrayList list = new ArrayList();
        /*list.add(answer.get);
        list.add(answer.get);
        list.add(answer.get);
        list.add(answer.get);
        list.add(answer.get);*/
        int count=0;
        List<Answer> find = mongoTemplate.find(null, Answer.class);
        for (int i =1; i <=5 ; i++) {

            if (find.get(i).getContent().equals(list.get(i))) {

                count++;
            }else{

                Integer id = find.get(i).getId();
            }

        }
        return count;
    }











}
