package com.jk.mapper;

import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;

public interface PlayMapper {

    void updateBlance(@Param("jg") Integer jg, @Param("id") Integer id);

    User selectUserBalance(Integer id);

    void addVIP(User user);
}
