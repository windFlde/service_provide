package com.jk.service.impl;

import com.jk.bean.Echarts;
import com.jk.mapper.EachartsMapper;
import com.jk.service.EachartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EachartsServiceImpl implements EachartsService {

    @Resource
    private EachartsMapper eachartsMapper;
    @Override
    public List<Echarts> queryEcharts(Integer id) {
        return eachartsMapper.queryEcharts(id);
    }

    @Override
    public ArrayList<Echarts> queryEchartsTwo() {
        return eachartsMapper.queryEchartsTwo();
    }
}
