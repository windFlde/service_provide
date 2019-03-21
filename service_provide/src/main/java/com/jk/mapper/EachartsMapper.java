package com.jk.mapper;

import com.jk.bean.Echarts;

import java.util.ArrayList;
import java.util.List;

public interface EachartsMapper {

    List<Echarts> queryEcharts(Integer id);

    ArrayList<Echarts> queryEchartsTwo();
}
