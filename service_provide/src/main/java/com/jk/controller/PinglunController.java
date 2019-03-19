package com.jk.controller;

import com.jk.bean.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
        if (user!= null) {
            pinglunTree.setUserId(user.getId());
            pinglunTree.setImg(user.getImg());
            pinglunTree.setName(user.getUsername());
            pinglunTree.setTime(df.format(new Date()));


        }
        pinglunTree.setTime(df.format(new Date()));
        mongoTemplate.save(pinglunTree);
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

        PingLunTwo pinglunTree = new PingLunTwo();
        pinglunTree.set_id(id);
        mongoTemplate.remove(pinglunTree);

        return "success";

    }

    /**
     * 患者视频留言
     */
    @RequestMapping("addLiuyanTwo")
    public String addLiuyanTwo(PinglunFour pinglunFour,HttpSession session) {


        User user = (User) session.getAttribute("user");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
        if (user!= null) {
            pinglunFour.setUserId(user.getId());
            pinglunFour.setImg(user.getImg());
            pinglunFour.setName(user.getUsername());
            pinglunFour.setTime(df.format(new Date()));


        }
        pinglunFour.setTime(df.format(new Date()));

        mongoTemplate.save(pinglunFour);
        System.out.println(pinglunFour);

        return "success";
    }

    @RequestMapping("queryLiuyanTwo")
    public List<PinglunFour> queryLiuyanTwo(Integer id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        List<PinglunFour> list = mongoTemplate.find(query, PinglunFour.class);
        return  list;
    }

    @RequestMapping("deleteLiuyan2")
    public String deleteLiuyan2(String id) {

        PinglunFour pinglunFive = new PinglunFour();
        pinglunFive.set_id(id);
        mongoTemplate.remove(pinglunFive);

        return "success";

    }

    /**
     * 新增会议直播留言
     * @param pinglunFive
     * @param session
     * @return
     */
    @RequestMapping("addLiuyanFive")
    public String addLiuyanFive(PinglunFive pinglunFive,HttpSession session) {

        User user = (User) session.getAttribute("user");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式

        if (user != null) {
            pinglunFive.setTime(df.format(new Date()));// new Date()为获取当前系统时间
            pinglunFive.setUserId(user.getId());
            pinglunFive.setName(user.getUsername());
            pinglunFive.setImg(user.getImg());
        }
        pinglunFive.setTime(df.format(new Date()));
        mongoTemplate.save(pinglunFive);
        return "success";
    }

    /**
     * 查询会议直播留言
     * @param id
     * @return
     */
    @RequestMapping("queryLiuyanFive")
    public List<PinglunFive> queryLiuyanFive(Integer id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        List<PinglunFive> list = mongoTemplate.find(query, PinglunFive.class);
        return list;
    }

    /**
     * 精品留言
     */
    @RequestMapping("queryLiuyanById")
    public List<PinglunFive> queryLiuyanById(Integer em_id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(em_id));
        List<PinglunFive> list = mongoTemplate.find(query, PinglunFive.class);
        return list;
    }

    /**
     * 回复
     */
    @RequestMapping("huifu")
    public void huifu(String _id,String huifu,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(_id));
            Update huifu1 = new Update().set("huifu", huifu);
            Update huifu2 = new Update().set("aa", "丨作者回复");
            mongoTemplate.updateFirst(query,huifu1,PinglunFour.class);
            mongoTemplate.updateFirst(query,huifu2,PinglunFour.class);

        }

    }





}
