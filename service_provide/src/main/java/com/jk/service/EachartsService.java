package com.jk.service;

import com.jk.bean.Echarts;

import java.util.ArrayList;
import java.util.List;

public interface EachartsService {

    List<Echarts> queryEcharts(Integer id);


    ArrayList<Echarts> queryEchartsTwo();
}
