package com.jk.mapper;

import com.jk.bean.DaKa;
import com.jk.bean.Exprent;
import com.jk.bean.WenZhang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeMapper {
    List<Exprent> getzhuanjia();

    List<Exprent> getzanmei();

    List<WenZhang> getTitle();

    List<Exprent> getAllzhuanjia1();

    List<Exprent> getAllzhuanjia0();

    Exprent getJJ(@Param("id") String id);

    List<WenZhang> getGoodsWord(@Param("id") String id);

    WenZhang getneirong(@Param("id") String id);

    void updateBrowse(@Param("id") String id);

    DaKa getdaka(@Param("id") String id);

    List<DaKa> getMaster();
}
