package com.jk.mapper;

import com.jk.bean.Guandian;

import java.util.List;

public interface ExprentViewMapper {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);
}
