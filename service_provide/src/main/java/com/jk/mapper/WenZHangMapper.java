package com.jk.mapper;

import com.jk.bean.Order;
import com.jk.bean.Redeem;
import com.jk.bean.User;
import com.jk.bean.WenZhang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WenZHangMapper {

    WenZhang queryWen(WenZhang wenZhang);

    List<Redeem> getIntegral();

    Redeem exIntegral(Redeem redeem);

    User getUserMes(String userId);

    void updateUserCount(@Param("feiyong") Integer feiyong, @Param("id") Integer id);

    void updateDuiHuanCount(@Param("id") Integer id, @Param("feiyong") Integer feiyong);

    Redeem insertOrder(Integer goodsId);

    void InsertOrderGoods(@Param("r") Redeem re, @Param("userId") Integer userId);

    User getUserAll(Integer id);

    List<Order> getUserOrder(Order order);

    void insertIntegral(@Param("feiyong") String feiyong, @Param("name") String name, @Param("id") Integer id);
}
