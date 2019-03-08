package com.jk.mapper;

import com.jk.bean.WenXian;

import java.util.List;

public interface WenXianMapper {

    List<WenXian> queryWenXIan();

    void updateBrowse(WenXian wenXian);

    WenXian queryXiangQing(WenXian wenXian);
}
