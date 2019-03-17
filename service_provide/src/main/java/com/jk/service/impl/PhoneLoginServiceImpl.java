package com.jk.service.impl;


import com.jk.bean.QueryParam;
import com.jk.bean.User;
import com.jk.mapper.PhoneLoginMapper;
import com.jk.service.PhoneLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhoneLoginServiceImpl implements PhoneLoginService {

    @Resource
    private PhoneLoginMapper phoneLoginMapper;

    @Override
    public User sendCode(QueryParam queryParam) {
        return phoneLoginMapper.sendCode(queryParam);
    }

    @Override
    public Integer queryUserBlack(Integer id) {
        return  phoneLoginMapper.queryUserBlack(id);
    }

    @Override
    public List<User> registerUserAccount() {
        return phoneLoginMapper.registerUserAccount();
    }
}
