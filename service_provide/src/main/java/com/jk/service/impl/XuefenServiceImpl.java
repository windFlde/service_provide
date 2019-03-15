package com.jk.service.impl;

import com.jk.bean.Xuefen;
import com.jk.mapper.XuefenMapper;
import com.jk.service.XuefenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XuefenServiceImpl implements XuefenService {

    @Resource
    private XuefenMapper xuefenMapper;

    @Override
    public List<Xuefen> queryXuefen() {
        return xuefenMapper.queryXuefen();
    }

   /* @Override
    public List<Xuefen> queryXuefenTwo(Xuefen xuefen) {
        return xuefenMapper.queryXuefenTwo(xuefen);
    }*/


}
