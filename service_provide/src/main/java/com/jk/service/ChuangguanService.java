package com.jk.service;

import com.jk.bean.User;

import java.util.List;

public interface ChuangguanService {

    List<User> queryChuangguan();

    void upateCount(User user);
}
