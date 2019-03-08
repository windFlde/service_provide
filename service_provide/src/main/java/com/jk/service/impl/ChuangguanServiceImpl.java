package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.ChuangguanMapper;
import com.jk.service.ChuangguanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChuangguanServiceImpl implements ChuangguanService {

    @Resource
    private ChuangguanMapper chuangguanMapper;

    @Override
    public List<User> queryChuangguan() {
        return chuangguanMapper.queryChuangguan();
    }


}
