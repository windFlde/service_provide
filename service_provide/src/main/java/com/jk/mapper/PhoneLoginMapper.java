package com.jk.mapper;

import com.jk.bean.QueryParam;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PhoneLoginMapper {

    @Select("select * from t_user where phone =#{phone_no}")
    User sendCode(QueryParam queryParam);

    @Select("select count(userId) from t_user_black where userId = #{id}")
    Integer queryUserBlack(Integer id);

    List<User> registerUserAccount();
}
