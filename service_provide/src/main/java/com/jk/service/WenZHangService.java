package com.jk.service;

import com.jk.bean.Order;
import com.jk.bean.Redeem;
import com.jk.bean.User;
import com.jk.bean.WenZhang;

import java.util.List;

public interface WenZHangService {

    WenZhang queryWen(WenZhang wenZhang);

    List<Redeem> getIntegral();

    Redeem exIntegral(Redeem redeem);

    User getUserMes(String userId);

    void updateUserCount(Integer feiyong, Integer id);

    void updateDuiHuanCount(Integer id, Integer feiyong);

    Redeem insertOrder(Integer goodsId);

    void InsertOrderGoods(Redeem re, Integer userId);

    User getUserAll(Integer id);

    List<Order> getUserOrder(Order order);

    void insertIntegral(String feiyong, String name, Integer id);
}
