package com.jk.service.impl;

import com.jk.bean.Oder;
import com.jk.mapper.OrderMapper;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Oder getwenzhang(String wzid) {
        return orderMapper.getwenzhang(wzid);
    }
}
