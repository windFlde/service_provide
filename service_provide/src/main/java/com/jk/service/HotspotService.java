package com.jk.service;

import com.jk.bean.Hotspot;

import java.util.List;

public interface HotspotService {

    List<Hotspot> queryHotspot(Integer page, Integer rows);


    Hotspot queryHotspotChildren(Hotspot hotspot);

    void updateRdzxOne(Integer id);


}
