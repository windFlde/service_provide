package com.jk.controller;

import com.jk.bean.PinglunTree;
import com.jk.bean.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PinglunController {

    @Resource
    MongoTemplate mongoTemplate;

    @RequestMapping("addLiu")
    public String addLiu(PinglunTree pinglunTree, HttpSession session) {

        User user = (User) session.getAttribute("user");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.mm.dd");
        String format = simpleDateFormat.format(new Date());
        if (user!= null) {
            /*pinglunTree.setUserId(user.getId());*/
            pinglunTree.setImg(user.getImg());
            pinglunTree.setName(user.getUsername());
            /*pinglunTree.setTime(format);*/


        }

        mongoTemplate.save(pinglunTree);
        System.out.println(pinglunTree);
        return "success";
    }

    @RequestMapping("queryLiuyan")
    public List<PinglunTree> queryLiuyan(Integer id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        List<PinglunTree> list=mongoTemplate.find(query, PinglunTree.class);
        return list;
    }

    @RequestMapping("deleteLiuyan")
    public String deleteLiuyan(String id) {

        PinglunTree pinglunTree = new PinglunTree();
        pinglunTree.set_id(id);
        mongoTemplate.remove(pinglunTree);

        return "success";

    }
}
