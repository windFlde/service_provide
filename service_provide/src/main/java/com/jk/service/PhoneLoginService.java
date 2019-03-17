package com.jk.service;

import com.jk.bean.QueryParam;
import com.jk.bean.User;

import java.util.List;

public interface PhoneLoginService  {

    User sendCode(QueryParam queryParam);

    Integer queryUserBlack(Integer id);

    List<User> registerUserAccount();
}
