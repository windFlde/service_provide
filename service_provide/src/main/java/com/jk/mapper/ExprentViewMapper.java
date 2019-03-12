package com.jk.mapper;

import com.jk.bean.DaKa;
import com.jk.bean.Exprent;
import com.jk.bean.Guandian;

import java.util.List;

public interface ExprentViewMapper {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);

    List<DaKa> queryLive();

    DaKa queryZhibo(Integer id);

    void addBaoming();
}
