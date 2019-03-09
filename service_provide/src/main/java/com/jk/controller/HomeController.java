package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.*;
import com.jk.service.HomeService;
import com.jk.util.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @RequestMapping("ToPage")
    public String ToPage(String name) {
        return name;
    }

    @ResponseBody
    @RequestMapping("getzhuanjia")
    public List<Exprent> getzhuanjia() {
        List<Exprent> list = homeService.getzhuanjia();
        return list;
    }

    @ResponseBody
    @RequestMapping("getzanmei")
    public List<Exprent> getzanmei() {
        return homeService.getzanmei();
    }

    @ResponseBody
    @RequestMapping("getTitle")
    public List<WenZhang> getTitle() {
        return homeService.getTitle();
    }

    @RequestMapping("to")
    public String to(String tmp, Model model) {
        model.addAttribute("tmp", tmp);
        return "zhuanjia";
    }

    @RequestMapping("tojj")
    public String tojj(String id, Model model, String tmp) {
        model.addAttribute("id", id);
        model.addAttribute("tmp", tmp);
        return "zhuozhejj";
    }

    @RequestMapping("towenzhang")
    public String towenzhang(String id, Model model ,String tmp){
        model.addAttribute("id",id);
        model.addAttribute("tmp",tmp);
        return "jingxuanwenzhang";
    }

    @RequestMapping("toneirong")
    public String toneirong(String id, Model model,String tmp ){
        model.addAttribute("id",id);
        model.addAttribute("tmp",tmp);
        return "jingxuanneirong";
    }

    @RequestMapping("tozhuanjiaOnline")
    public String tozhuanjiaOnline(String id,Model model){
        model.addAttribute("tmp",id);
        return "zhuanjiaOnline";
    }

    @ResponseBody
    @RequestMapping("getAllzhuanjia")
    public List<Exprent> getAllzhuanjia(String tmp) {
        return homeService.getAllzhuanjia(tmp);
    }

    @ResponseBody
    @RequestMapping("getJJ")
    public Exprent getJJ(String id) {
        return homeService.getJJ(id);
    }

    @ResponseBody
    @RequestMapping("getGoodsWord")
    public List<WenZhang> getGoodsWord(String id){
        return homeService.getGoodsWord(id);
    }

    @ResponseBody
    @RequestMapping("getneirong")
    public WenZhang getneirong(String id){
        return homeService.getneirong(id);
    }

    @ResponseBody
    @RequestMapping("updateBrowse")
    public void updateBrowse(String id){
        homeService.updateBrowse(id);
    }

    @RequestMapping("todaka")
    public String todaka(String id, Model model ){
        model.addAttribute("id",id);
        return "dakaOnline";
    }
    @ResponseBody
    @RequestMapping("getdaka")
    public DaKa getdaka(String id){
        return homeService.getdaka(id);
    }

    @ResponseBody
    @RequestMapping("sendSay")
    public Say sendSay(String info){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", "bd8f47022fd1448a9e34241cb4948b54");
        params.put("info", info);
        String result = HttpClient.sendGet("http://www.tuling123.com/openapi/api", params);
        JSONObject parseObject = JSONObject.parseObject(result);
        String string2 = JSONObject.toJSONString(parseObject);
        Say object = JSONObject.parseObject(string2,Say.class);
        return object;
    }

    @ResponseBody
    @RequestMapping("getMaster")
    public List<DaKa> getMaster(){
        return homeService.getMaster();
    }

    @ResponseBody
    @RequestMapping("getjifenData")
    public List<Integral> getjifenData(String userId){
        return homeService.getjifenData(userId);
    }


}
