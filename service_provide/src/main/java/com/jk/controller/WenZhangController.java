package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.*;
import com.jk.service.WenZHangService;
import com.jk.util.Constant;
import com.jk.util.HttpClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wenz")
public class WenZhangController {

    @Resource
    private WenZHangService wenZHangService;

    @Resource
    private MongoTemplate mongoTemplate;
    //wuyong

    @ResponseBody
    @RequestMapping("queryWen")
    public WenZhang queryWen(WenZhang wenZhang) {

        WenZhang wen = wenZHangService.queryWen(wenZhang);
        String localhostIP = getLocalHostIP();

        String ProjectURL = getProjectURL(localhostIP);
        System.out.println(ProjectURL);

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
    @ResponseBody
    @RequestMapping("queryTitleName")
    public List<TitleName> queryTitleName() {
        List<TitleName> titleName=mongoTemplate.find(null,TitleName.class);
        return titleName;
    }
    @ResponseBody
    @RequestMapping("getTitleCookie")
    public String getTitleCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constant.titleName)) {
                    String val = cookie.getValue();
                    if (val.equals("0")) {
                        return "0";
                    }else if(val.equals("1")){
                        return "1";
                    }
                }
            }
        }
        return "0";
    }
    @ResponseBody
    @RequestMapping("insertTitleName")
    public String insertTitleName(HttpServletResponse response,String ziduan) {
        Cookie cc=new Cookie(Constant.titleName,"1");
        cc.setMaxAge(60);
        cc.setPath("/");
        response.addCookie(cc);
        return "1";
    }

    @ResponseBody
    @RequestMapping("getMoadlContent")
    public List<MainContent> getMoadlContent() {
        List<MainContent>list=wenZHangService.getMoadlContent();
        return list;
    }
    @ResponseBody
    @RequestMapping("mainModal")
    public String mainModal(HttpServletResponse response,String ziduan) {
        Cookie cc=new Cookie(Constant.mainModal,"1");
        cc.setMaxAge(60);
        cc.setPath("/");
        response.addCookie(cc);
        return "1";
    }
    @ResponseBody
    @RequestMapping("getMainModalCookie")
    public String getMainModalCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constant.mainModal)) {
                    String val = cookie.getValue();
                    if (val.equals("0")) {
                        return "0";
                    }else{
                        return "1";
                    }
                }
            }
        }
        return "0";
    }


    @ResponseBody
    @RequestMapping("getErwei")
    public String maps(String data) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", "8de4433d4771d8486ca8baff5cd8d8c0");
        params.put("text",data);
        String allresult = HttpClient.sendGet("http://apis.juhe.cn/qrcode/api", params);
        JSONObject jsonObject = JSONObject.parseObject(allresult);
        JSONObject result = jsonObject.getJSONObject("result");
        String base64_image = result.getString("base64_image");
        return base64_image;
    }



    //获取当前内网IP地址
    public static String getLocalHostIP(){
        String result = null;

        try {

            InetAddress IP = Inet4Address.getLocalHost();
            String ip = IP.toString();

            int index = ip.indexOf('/');

            result = ip.substring(index+1, ip.length());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getProjectURL(String IP){
        String result = "http://";

        result += IP;
        result += ":8080/";

        String proPath = System.getProperty("user.dir");
        String proName = proPath.substring(proPath.lastIndexOf("\\")+1, proPath.length());

        result += proName;

        return result;
    }


}
