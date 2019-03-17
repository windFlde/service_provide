package com.jk.service.impl;

import com.jk.mapper.PlayMapper;
import com.jk.service.PlayService;
import jdk.nashorn.internal.ir.annotations.Ignore;
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
}
