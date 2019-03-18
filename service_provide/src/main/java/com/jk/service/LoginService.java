package com.jk.service;

import com.jk.bean.User;

public interface LoginService {

    User toLogin(User users);

    User toLoginByQQ(String opens);
}
