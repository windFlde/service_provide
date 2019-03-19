package com.jk.controller;

import com.jk.bean.*;
import com.jk.client.SearchClient;
import com.jk.service.BckService;
import com.jk.service.WenZHangService;
import com.jk.util.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("bck")
public class BckController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    BckService bckService;
    @Resource
    WenZHangService wenZHangService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Resource
    SearchClient searchClient;

    @ResponseBody
    @RequestMapping("getTitle")
    public List<Example> getTitle(@RequestParam(value = "name")String name){
        List<Example> title = searchClient.getTitle(name);
        return title;
    }

    @ResponseBody
    @RequestMapping("addPingLun")
    public String addPingLun(PingLun pingLun,HttpSession session){

        User user = (User)session.getAttribute("user");
        Integral integral = new Integral();
        Integer id = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String format = simpleDateFormat.format(new Date());
        if(user!=null){
            pingLun.setName(user.getUsername());
            pingLun.setImg(user.getImg());
            pingLun.setTime(format);
            pingLun.setUserId(user.getId());
            id = user.getId();
        }
        List<Sensitivity> list = bckService.querySs();
        boolean contains = false;
        for (Sensitivity sensitivity : list) {
            contains = pingLun.getContent().contains(sensitivity.getContent());
            if(contains){
                break;
            }
        }
        if(contains){
            pingLun.setBlack(0);
            mongoTemplate.save(pingLun);
            return "1";
        }else {
            pingLun.setBlack(1);
            mongoTemplate.save(pingLun);
            Integer em_id = pingLun.getEm_id();
            List<PingLun> pingLuns = queryPingLun(em_id);
            if(id != null&&pingLuns.size()<=5){
                bckService.addCount(id);
                integral.setIgName("留言");
                integral.setUserId(id);
                bckService.addIg(integral);
            }else {
                return "2";
            }
            return "0";
        }

    }
    @ResponseBody
    @RequestMapping("addPingLun2")
    public String addPingLun2(PingLunTwo pingLun, HttpSession session){

        User user = (User)session.getAttribute("user");
        Integral integral = new Integral();
        Integer id = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String format = simpleDateFormat.format(new Date());
        if(user!=null){
            pingLun.setName(user.getUsername());
            pingLun.setImg(user.getImg());
            pingLun.setTime(format);
            pingLun.setUserId(user.getId());
            id = user.getId();
        }
        List<Sensitivity> list = bckService.querySs();
        boolean contains = false;
        for (Sensitivity sensitivity : list) {
            contains = pingLun.getContent().contains(sensitivity.getContent());
            if(contains){
                break;
            }
        }
        if(contains){
            pingLun.setBlack(0);
            mongoTemplate.save(pingLun);
            return "1";
        }else {
            pingLun.setBlack(1);
            mongoTemplate.save(pingLun);
            Integer em_id = pingLun.getEm_id();
            List<PingLun> pingLuns = queryPingLun(em_id);
            if(id != null&&pingLuns.size()<=5){
                bckService.addCount(id);
                integral.setIgName("留言");
                integral.setUserId(id);
                bckService.addIg(integral);
            }else {
                return "2";
            }
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping("queryPingLun")
    public List<PingLun> queryPingLun(Integer id){

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        query.addCriteria(Criteria.where("black").is(1));
        List<PingLun> pingLuns = mongoTemplate.find(query,PingLun.class);
        return pingLuns;
    }

    @ResponseBody
    @RequestMapping("queryCommit")
    public List<PingLun> queryCommit(Integer id,String black){

        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(id));
        if(black.equals("1")){
            query.addCriteria(Criteria.where("black").is(1));
        }else {
            query.addCriteria(Criteria.where("black").is(0));
        }
        List<PingLun> pingLuns = mongoTemplate.find(query, PingLun.class);
        return pingLuns;
    }


    @ResponseBody
    @RequestMapping("queryPingLun2")
    public List<PingLunTwo> queryPingLun2(Integer id){

        Query query = new Query();
        query.addCriteria(Criteria.where("em_id").is(id));
        query.addCriteria(Criteria.where("black").is(1));
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
    /*使用积分购买收费文章*/
    @ResponseBody
    @RequestMapping("payEx")
    public String payEx(Integer emId,Integer num,HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user.getNum()>num){
           /* bckService.addPay(id,emId);*/
            wenZHangService.updateUserCount(num,user.getId());
            wenZHangService.insertIntegral("-"+num,"购买文章",user.getId());
            redisTemplate.opsForList().leftPush(Content.pay+user.getId()+emId,"aa");
            redisTemplate.expire(Content.pay+user.getId()+emId,30, TimeUnit.MINUTES);
            return "1";
        }else {
            return "0";
        }
    }

    /*使用支付宝支付*/
    @ResponseBody
    @RequestMapping("zfbPlay")
    public String zfbPlay(Integer emId,HttpSession session,Integer mony) {
        User user = (User)session.getAttribute("user");
        wenZHangService.insertIntegral("-￥"+mony,"购买文章",user.getId());
        redisTemplate.opsForList().leftPush(Content.pay+user.getId()+emId,"aa");
        redisTemplate.expire(Content.pay+user.getId()+emId,30, TimeUnit.MINUTES);
        return "1";
    }

    /*查看每篇收费文章的价格*/
    @ResponseBody
    @RequestMapping("payMony")
    public Pay payMony(Integer emId) {
        return bckService.payMony(emId);
    }
    /*判断是否购买*/
    @ResponseBody
    @RequestMapping("paySuccess")
    public String paySuccess(Integer emId,HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(redisTemplate.hasKey(Content.pay+user.getId()+emId)){
            return "1";
        }else {
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping("queryExampleById")
    public Example queryExampleById(Integer id,HttpSession session) {
        Example example = bckService.queryExampleById(id);
        return example;
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
