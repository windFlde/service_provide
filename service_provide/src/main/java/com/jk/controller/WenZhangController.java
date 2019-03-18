package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.WenZHangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("wenz")
public class WenZhangController {

    @Resource
    private WenZHangService wenZHangService;

    //wuyong

    @ResponseBody
    @RequestMapping("queryWen")
    public WenZhang queryWen(WenZhang wenZhang) {
        WenZhang wen = wenZHangService.queryWen(wenZhang);
        return wen;
    }

    @RequestMapping("toView")
    public String toView(String viewName) {
        return viewName;
    }

    @ResponseBody
    @RequestMapping("setTitleVal")
    public String setTitleVal(HttpSession session, WenZhang wenZhang) {
        session.setAttribute("wenZhang", wenZhang);
        return "";
    }
    @ResponseBody
    @RequestMapping("getIntegral")
    public List<Redeem>getIntegral() {
        List<Redeem>list=wenZHangService.getIntegral();
        return list;
    }
    Redeem reAll=null;
    User userAll=null;
    @ResponseBody
    @RequestMapping("exIntegral")
    public String exIntegral(Redeem redeem,Integer userId) {
        Redeem re=wenZHangService.exIntegral(redeem);
        User user=wenZHangService.getUserMes(userId);
        reAll=re;
        userAll=user;
        if (re.getCount() <= 0) {
            return "countNo";
        } else if(re.getFeiyong()>user.getNum()){
            return "userNo";
        } else{
            wenZHangService.updateUserCount(re.getFeiyong(),user.getId());
            wenZHangService.updateDuiHuanCount(re.getId(),re.getFeiyong());
            return "countOk";
        }
    }
    //生成消费记录
    @ResponseBody
    @RequestMapping("insertIntegral")
    public String insertIntegral() {
        if (reAll!=null) {
            wenZHangService.insertIntegral("-"+reAll.getFeiyong(),reAll.getName(),userAll.getId());
            return "insertIntegral";
        }
        return "1";
    }
    //生成订单
    @ResponseBody
    @RequestMapping("insertOrder")
    public String insertOrder(QueryParam queryParam) {
        if (queryParam.getGoodsId()!=null) {
            Redeem re=wenZHangService.insertOrder(queryParam.getGoodsId());
            if (re != null) {
                wenZHangService.InsertOrderGoods(re,queryParam.getUserId());
                return "insertOrderOk";
            }
        }

        return "1";
    }
    @ResponseBody
    @RequestMapping("toLogin")
    public String toLogin(HttpSession session,QueryParam queryParam) {
        session.setAttribute("reUrl",queryParam);
        return "";
    }
    @ResponseBody
    @RequestMapping("removeReUrl")
    public String removeReUrl(HttpSession session) {
        session.removeAttribute("reUrl");
        return "";
    }

    @ResponseBody
    @RequestMapping("getUserAll")
    public User getUserAll(User user) {
        User userf=wenZHangService.getUserAll(user.getId());
        return userf;
    }

    @ResponseBody
    @RequestMapping("getUserOrder")
    public List<Order>getUserOrder(Order order) {
        List<Order>or=wenZHangService.getUserOrder(order);
        return or;
    }


}
