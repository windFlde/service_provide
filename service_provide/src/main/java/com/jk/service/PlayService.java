package com.jk.service;

import com.jk.bean.User;

public interface PlayService {

    void updateBlance(Integer jg,Integer id);

    User selectUserBalance(Integer id);

    void addVIP(User user);
}
