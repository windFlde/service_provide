package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.BckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("bck")
public class BckController {

    @Resource
    BckService bckService;

    @Autowired
    MongoTemplate mongoTemplate;

    @ResponseBody
    @RequestMapping("addPingLun")
    public void addPingLun(PingLun pingLun, HttpSession session){

        User user = (User)session.getAttribute("user");
        Integral integral = new Integral();
        Integer id = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.mm.dd");
        String format = simpleDateFormat.format(new Date());
        if(user!=null){
            pingLun.setName(user.getUsername());
            pingLun.setImg(user.getImg());
            pingLun.setTime(format);
            pingLun.setUserId(user.getId());
            id = user.getId();
        }
        mongoTemplate.save(pingLun);
        if(id != null){
            bckService.addCount(id);
            integral.setIgName("留言");
            integral.setUserId(id);
            bckService.addIg(integral);
        }
    }

    @ResponseBody
    @RequestMapping("addPingLun2")
    public void addPingLun2(PingLunTwo pingLun, HttpSession session){

        User user = (User)session.getAttribute("user");
        Integral integral = new Integral();
        Integer id = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.mm.dd");
        String format = simpleDateFormat.format(new Date());
        if(user!=null){
            pingLun.setName(user.getUsername());
            pingLun.setImg(user.getImg());
            pingLun.setTime(format);
            pingLun.setUserId(user.getId());
            id = user.getId();
        }
        mongoTemplate.save(pingLun);
        if(id != null){
            bckService.addCount(id);
            integral.setIgName("留言");
            integral.setUserId(id);
            bckService.addIg(integral);
        }
    }


    @ResponseBody
    @RequestMapping("queryPingLun")
    public List<PingLun> queryPingLun(Integer id){

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        List<PingLun> pingLuns = mongoTemplate.find(query, PingLun.class);
        return pingLuns;
    }

    @ResponseBody
    @RequestMapping("queryPingLun2")
    public List<PingLunTwo> queryPingLun2(Integer id){

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        List<PingLunTwo> pingLuns = mongoTemplate.find(query, PingLunTwo.class);
        return pingLuns;
    }

    @ResponseBody
    @RequestMapping("updateHf")
    public void updateHf(String huifu,String id,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user!=null){
            if(user.getId()==6){
                Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(id));
                Update huifu1 = new Update().set("huifu", huifu);
                Update huifu2 = new Update().set("aa", "丨作者回复");
                mongoTemplate.updateFirst(query,huifu1,PingLun.class);
                mongoTemplate.updateFirst(query,huifu2,PingLun.class);
            }
        }
    }



    @ResponseBody
    @RequestMapping("queryExample1")
    public List<Example> queryExample1(Integer page, Integer rows) {
        List<Example> list = bckService.queryExample(page, rows);
        return list;
    }

    @ResponseBody
    @RequestMapping("queryExampleById")
    public Example queryExampleById(Integer id) {

        return bckService.queryExampleById(id);
    }

    @ResponseBody
    @RequestMapping("updateById")
    public void updateById(Integer id) {
        bckService.updateById(id);
    }

    @ResponseBody
    @RequestMapping("addShouCang")
    public String addShouCang(ShouCang shouCang,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "0";
        }else {
            boolean b = bckService.querySc(shouCang.getTitle());
            if(b){
                return "2";
            }else {
                shouCang.setUserId(user.getId());
                bckService.addShouCang(shouCang);
                return "1";
            }
        }

    }

    @ResponseBody
    @RequestMapping("queryShouCang")
    public List<ShouCang> queryShouCang(HttpSession session){

        User user = (User) session.getAttribute("user");

        if(user!=null){
            Integer id = user.getId();

            return bckService.queryShouCang(id);
        }else {
            return null;
        }
    }

}
