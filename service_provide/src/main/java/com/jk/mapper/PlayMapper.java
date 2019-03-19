package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

public interface PlayMapper {

    void updateBlance(@Param("jg") Integer jg, @Param("id") Integer id);
}
