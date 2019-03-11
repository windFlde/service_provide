package com.jk.mapper;

import com.jk.bean.Hotspot;

import java.util.List;

public interface HotspotMapper {

    List<Hotspot> queryHotspot();

    Hotspot queryHotspotChildren(Hotspot hotspot);

    void updateRdzxOne(Integer id);


}
