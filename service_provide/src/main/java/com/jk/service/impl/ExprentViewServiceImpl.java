package com.jk.service.impl;

import com.jk.bean.Baoming;
import com.jk.bean.DaKa;
import com.jk.bean.Exprent;
import com.jk.bean.Guandian;
import com.jk.mapper.ExprentViewMapper;
import com.jk.service.ExprentViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExprentViewServiceImpl implements ExprentViewService {

    @Resource
    public ExprentViewMapper exprentViewMapper;

    @Override
    public List<Guandian> querExprent() {
        return exprentViewMapper.querExprent();
    }

    @Override
    public Guandian querExprentList(Integer id) {
        return exprentViewMapper.querExprentList(id);
    }

    @Override
    public List<DaKa> queryLive() {
        return exprentViewMapper.queryLive();
    }

    @Override
    public DaKa queryZhibo(Integer id) {
        return exprentViewMapper.queryZhibo(id);
    }

    @Override
    public void addBaoming(Baoming baoming) {
        exprentViewMapper.addBaoming();
    }

}
