package com.jk.service;

import com.jk.bean.WenXian;

import java.util.List;

public interface WenXianService {

    List<WenXian> queryWenXIan();

    void updateBrowse(WenXian wenXian);

    WenXian queryXiangQing(WenXian wenXian);
}
