package com.jk.service.impl;

import com.jk.bean.WenZhang;
import com.jk.mapper.WenZHangMapper;
import com.jk.service.WenZHangService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WenZHangServiceImpl implements WenZHangService {

    @Resource
    private WenZHangMapper wenZhangMapper;


    @Override
    public WenZhang queryWen(WenZhang wenZhang) {
        return wenZhangMapper.queryWen(wenZhang);
    }
}
