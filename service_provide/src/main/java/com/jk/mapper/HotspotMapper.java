package com.jk.mapper;

import com.jk.bean.Hotspot;
import com.jk.bean.ShouCang;

import java.util.List;

public interface HotspotMapper {

    List<Hotspot> queryHotspot();

    Hotspot queryHotspotChildren(Hotspot hotspot);

    void updateRdzxOne(Integer id);


    ShouCang querysc(String title);

    void addShoucang(ShouCang shouCang);
}
