package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface WenZHangMapper {

    WenZhang queryWen(WenZhang wenZhang);

    List<Redeem> getIntegral();

    Redeem exIntegral(Redeem redeem);

    User getUserMes(Integer userId);

    void updateUserCount(@Param("feiyong") Integer feiyong, @Param("id") Integer id);

    void updateDuiHuanCount(@Param("id") Integer id, @Param("feiyong") Integer feiyong);

    Redeem insertOrder(Integer goodsId);

    void InsertOrderGoods(@Param("r") Redeem re, @Param("userId") Integer userId);

    User getUserAll(Integer id);

    List<Order> getUserOrder(Order order);

    void insertIntegral(@Param("feiyong") String feiyong, @Param("name") String name, @Param("id") Integer id);

    @Select("select * from t_main_content")
    List<MainContent> getMoadlContent();

    @Select("select * from t_main_content where cdate = #{date}")
    MainContent queryTitleNameTime(String date);

    @Select("SELECT * FROM `t_vistis` WHERE createTime = curdate() ;")
    Visits queryVistis(Date date);

    @Update("update t_vistis set count = #{count} where id=#{id}")
    void insertVistis(Visits visitsForDB);

    void addvistis(Visits visits);

    @Update("update t_user set num=num+ #{jifen} where id = #{id}")
    void addUserJiFen(@Param("jifen") Integer jifen, @Param("id") Integer id);
}
