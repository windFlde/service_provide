package com.jk.service;

import com.jk.bean.General;
import com.jk.bean.Oder;

import java.util.List;

public interface PatientService {
    List<General> queryVideo();

    List<General> queryManual();

    General queryHuanzejiaoyu(Integer id);

    General queryHuanzheTree(Integer id);

    Oder fsYouxiang(String id);

    void updatePeople(General general);
}
