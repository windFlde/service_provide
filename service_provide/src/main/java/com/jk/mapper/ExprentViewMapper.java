package com.jk.mapper;

import com.jk.bean.DaKa;
import com.jk.bean.Guandian;
import com.jk.bean.Img;

import java.util.List;

public interface ExprentViewMapper {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);

    List<DaKa> queryLive();

    DaKa queryZhibo(Integer id);

    void addBaoming();

    DaKa queryZhiboTwo(Integer id);

    Guandian queryGunadian(Integer id);

    void updatePeople(String id);

    void updatePeopleTwo(String id);

    Img queryImg(Integer id);
}
