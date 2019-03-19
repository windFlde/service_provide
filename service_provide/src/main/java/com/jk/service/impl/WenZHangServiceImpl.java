package com.jk.service.impl;

import com.jk.bean.Order;
import com.jk.bean.Redeem;
import com.jk.bean.User;
import com.jk.bean.WenZhang;
import com.jk.mapper.WenZHangMapper;
import com.jk.service.WenZHangService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WenZHangServiceImpl implements WenZHangService {

    @Resource
    private WenZHangMapper wenZhangMapper;


    @Override
    public WenZhang queryWen(WenZhang wenZhang) {
        return wenZhangMapper.queryWen(wenZhang);
    }

    @Override
    public List<Redeem> getIntegral() {
        return wenZhangMapper.getIntegral();
    }

    @Override
    public Redeem exIntegral(Redeem redeem) {
        return wenZhangMapper.exIntegral(redeem);
    }

    @Override
    public User getUserMes(String userId) {
        return wenZhangMapper.getUserMes(userId);
    }

    @Override
    public void updateUserCount(Integer feiyong, Integer id) {
        wenZhangMapper.updateUserCount(feiyong,id);
    }

    @Override
    public void updateDuiHuanCount(Integer id, Integer feiyong) {
        wenZhangMapper.updateDuiHuanCount(id,feiyong);
    }

    @Override
    public Redeem insertOrder(Integer goodsId) {
        return wenZhangMapper.insertOrder(goodsId);
    }

    @Override
    public void InsertOrderGoods(Redeem re, Integer userId) {
        wenZhangMapper.InsertOrderGoods(re,userId);
    }

    @Override
    public User getUserAll(Integer id) {
        return wenZhangMapper.getUserAll(id);
    }

    @Override
    public List<Order> getUserOrder(Order order) {
        return wenZhangMapper.getUserOrder(order);
    }

    @Override
    public void insertIntegral(String feiyong, String name, Integer id) {
        wenZhangMapper.insertIntegral(feiyong,name,id);
    }


}
