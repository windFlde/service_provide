package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public User toLogin(User users) {
        return loginMapper.toLogin(users);
    }
}
