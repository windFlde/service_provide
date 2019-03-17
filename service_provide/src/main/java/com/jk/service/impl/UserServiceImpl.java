package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.UserMapper;
import com.jk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void registerForm(User user) {
        userMapper.registerForm(user);
    }
}
