package com.jk.service;

import com.jk.bean.General;

import java.util.List;

public interface PatientService {
    List<General> queryVideo();

    List<General> queryManual();

    General queryHuanzejiaoyu(Integer id);

    General queryHuanzheTree(Integer id);
}
