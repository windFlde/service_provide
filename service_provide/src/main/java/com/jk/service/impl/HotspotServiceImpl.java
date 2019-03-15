package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Hotspot;
import com.jk.bean.ShouCang;
import com.jk.mapper.HotspotMapper;
import com.jk.service.HotspotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotspotServiceImpl implements HotspotService {

    @Resource
    private HotspotMapper hotspotMapper;

    @Override
    public List<Hotspot> queryHotspot(Integer page, Integer rows) {
        List <Hotspot> sum=hotspotMapper.queryHotspot(); //计算数据库符合条件的总条数   条数是固
        PageHelper.startPage(page,rows);
        List<Hotspot> list=hotspotMapper.queryHotspot();
        return list;
    }

    @Override
    public Hotspot queryHotspotChildren(Hotspot hotspot) {
        return hotspotMapper.queryHotspotChildren(hotspot);
    }

    @Override
    public void updateRdzxOne(Integer id) {
         hotspotMapper.updateRdzxOne(id);
    }

    @Override
    public boolean querysc(String title) {
        ShouCang shouCang=hotspotMapper.querysc(title);
        if (shouCang != null) {
            return true;
        }
        return false;
    }

    @Override
    public void addShoucang(ShouCang shouCang) {

        hotspotMapper.addShoucang(shouCang);
    }


}
