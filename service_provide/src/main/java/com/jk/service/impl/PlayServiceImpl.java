package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.PlayMapper;
import com.jk.service.PlayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlayServiceImpl implements PlayService {

    @Resource
    PlayMapper playMapper;


    @Override
    public void updateBlance(Integer jg,Integer id) {
        playMapper.updateBlance(jg,id);
    }

    @Override
    public void addVIP(User user) {
        playMapper.addVIP(user);
    }

    @Override
    public User selectUserBalance(Integer id) {
        return playMapper.selectUserBalance(id);
    }
}
