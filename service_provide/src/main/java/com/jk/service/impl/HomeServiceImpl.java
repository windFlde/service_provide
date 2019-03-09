package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.HomeMapper;
import com.jk.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeMapper homeMapper;

    @Override
    public List<Exprent> getzhuanjia() {
        return homeMapper.getzhuanjia();
    }

    @Override
    public List<Exprent> getzanmei() {
        return homeMapper.getzanmei();
    }

    @Override
    public List<WenZhang> getTitle() {
        return homeMapper.getTitle();
    }

    @Override
    public List<Exprent> getAllzhuanjia(String tmp) {
        if (tmp.equals("1")) {   //  1  是权威专家    0   是美赞专家
            return homeMapper.getAllzhuanjia1();
        } else {
            return homeMapper.getAllzhuanjia0();
        }
    }

    @Override
    public Exprent getJJ(String id) {
        return homeMapper.getJJ(id);
    }

    @Override
    public List<WenZhang> getGoodsWord(String id) {
        return homeMapper.getGoodsWord(id);
    }

    @Override
    public WenZhang getneirong(String id) {
        return homeMapper.getneirong(id);
    }

    @Override
    public void updateBrowse(String id) {
        homeMapper.updateBrowse(id);
    }

    @Override
    public DaKa getdaka(String id) {
        return homeMapper.getdaka(id);
    }

    @Override
    public List<DaKa> getMaster() {
        return homeMapper.getMaster();
    }

    @Override
    public List<Integral> getjifenData(String userId) {
        return homeMapper.getjifenData(userId);
    }


}
