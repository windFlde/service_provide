package com.jk.mapper;

import com.jk.bean.Oder;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    Oder getwenzhang(@Param("wzid") String wzid);
}
