package com.jk.service.impl;

import com.jk.bean.WenXian;
import com.jk.mapper.WenXianMapper;
import com.jk.service.WenXianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WenXianServiceImpl implements WenXianService {

    @Resource
    private WenXianMapper wenXianMapper;

    @Override
    public List<WenXian> queryWenXIan() {
        return wenXianMapper.queryWenXIan();
    }

    @Override
    public void updateBrowse(WenXian wenXian) {
        wenXianMapper.updateBrowse(wenXian);
    }

    @Override
    public WenXian queryXiangQing(WenXian wenXian) {
        return wenXianMapper.queryXiangQing(wenXian);
    }
}
