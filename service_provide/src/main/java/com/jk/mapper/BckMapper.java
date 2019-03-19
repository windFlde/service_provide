package com.jk.mapper;

import com.jk.bean.*;

import java.util.List;

public interface BckMapper {
    List<Example> queryExample();

    Example queryExampleById(Integer id);

    void updateById(Integer id);

    void addShouCang(ShouCang shouCang);

    List<ShouCang> queryShouCang(Integer id);

    void addCount(Integer id);

    void addIg(Integral integral);

    ShouCang querySc(String title);

    List<Sensitivity> querySs();

    Pay payMony(Integer emId);
}
