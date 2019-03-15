package com.jk.service;

import com.jk.bean.Hotspot;
import com.jk.bean.ShouCang;

import java.util.List;

public interface HotspotService {

    List<Hotspot> queryHotspot(Integer page, Integer rows);


    Hotspot queryHotspotChildren(Hotspot hotspot);

    void updateRdzxOne(Integer id);


    boolean querysc(String title);

    void addShoucang(ShouCang shouCang);
}
