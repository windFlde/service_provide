package com.jk.controller;

import com.jk.bean.Answer;
import com.jk.bean.User;
import com.jk.service.ChuangguanService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public String AddAnswer(Answer answer, Model model, HttpSession session) {

        List<Answer> find = mongoTemplate.find(null, Answer.class);
        if (find == null) {

            model.addAttribute("msg","选项错误");


        }else{

            model.addAttribute("msg","正确");

        }
        return "";
    }









}
