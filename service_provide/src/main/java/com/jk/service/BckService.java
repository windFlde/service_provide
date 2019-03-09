package com.jk.service;

import com.jk.bean.Example;
import com.jk.bean.ShouCang;

import java.util.List;

public interface BckService {

    List<Example> queryExample(Integer page, Integer rows);

    Example queryExampleById(Integer id);

    void updateById(Integer id);

    void addShouCang(ShouCang shouCang);

    List<ShouCang> queryShouCang(Integer id);
}
