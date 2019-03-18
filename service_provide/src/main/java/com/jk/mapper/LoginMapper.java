package com.jk.mapper;

import com.jk.bean.User;

public interface LoginMapper {

    User toLogin(User users);

    User toLoginByQQ(String opens);
}
