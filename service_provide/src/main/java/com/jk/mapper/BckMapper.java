package com.jk.mapper;

import com.jk.bean.Example;

import java.util.List;

public interface BckMapper {
    List<Example> queryExample();

    Example queryExampleById(Integer id);

    void updateById(Integer id);
}
