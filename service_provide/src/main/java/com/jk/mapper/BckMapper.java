package com.jk.mapper;

import com.jk.bean.Example;
import com.jk.bean.ShouCang;

import java.util.List;

public interface BckMapper {
    List<Example> queryExample();

    Example queryExampleById(Integer id);

    void updateById(Integer id);

    void addShouCang(ShouCang shouCang);

    List<ShouCang> queryShouCang(Integer id);
}
