package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface HomeService {
    List<Exprent> getzhuanjia();

    List<Exprent> getzanmei();

    List<WenZhang> getTitle();

    List<Exprent> getAllzhuanjia(String tmp);

    Exprent getJJ(String id);

    List<WenZhang> getGoodsWord(String id);

    WenZhang getneirong(String id);

    void updateBrowse(String id);

    DaKa getdaka(String id);

    List<DaKa> getMaster();

    List<Integral> getjifenData(String userId);

}
