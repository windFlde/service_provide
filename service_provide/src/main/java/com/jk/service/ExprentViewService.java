package com.jk.service;

import com.jk.bean.Baoming;
import com.jk.bean.DaKa;
import com.jk.bean.Exprent;
import com.jk.bean.Guandian;

import java.util.List;


public interface ExprentViewService {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);

    List<DaKa> queryLive();


    DaKa queryZhibo(Integer id);

    void addBaoming(Baoming baoming);
}
