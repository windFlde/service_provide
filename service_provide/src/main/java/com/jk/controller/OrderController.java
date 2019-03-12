package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.Oder;
import com.jk.service.OrderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    // 注入RabbitMQ操作模板类

    @Resource
    private AmqpTemplate amqpTemplate;

    @Resource
    OrderService orderService;

    @RequestMapping("saveOrder")
    public void saveOrder(String username,String email,String wzid){
        Oder oder = orderService.getwenzhang(wzid);
        oder.setUsername(username);
        oder.setEmail(email);

        //将对象转换为json串
        String orderJson = JSON.toJSONString(oder);

        // 往消息队列推送消息
        amqpTemplate.convertAndSend("1807B-01", orderJson);
    }

}
