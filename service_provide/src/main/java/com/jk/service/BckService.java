package com.jk.service;

import com.jk.bean.Example;

import java.util.List;

public interface BckService {

    List<Example> queryExample(Integer page, Integer rows);

    Example queryExampleById(Integer id);

    void updateById(Integer id);
}
