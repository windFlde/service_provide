package com.jk.service;

import com.jk.bean.Guandian;

import java.util.List;


public interface ExprentViewService {

    List<Guandian> querExprent();

    Guandian querExprentList(Integer id);
}
