package com.jk.service;

import com.jk.bean.*;

import java.util.List;


public interface ExprentViewService {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);

    List<DaKa> queryLive();


    DaKa queryZhibo(Integer id);

    void addBaoming(Baoming baoming);

    DaKa queryZhiboTwo(Integer id);

    Guandian queryGunadian(Integer id);
}
