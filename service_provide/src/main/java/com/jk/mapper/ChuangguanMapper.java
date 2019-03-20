package com.jk.mapper;

import com.jk.bean.User;

import java.util.List;

public interface ChuangguanMapper {

    List<User> queryChuangguan();

    void upateCount(User user);
}
