package com.jk.service.impl;

import com.jk.bean.General;
import com.jk.bean.Oder;
import com.jk.mapper.PatientMapper;
import com.jk.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    public List<General> queryVideo() {

        return patientMapper.queryVideo();
    }

    @Override
    public List<General> queryManual() {
        return patientMapper.queryManual();
    }

    @Override
    public General queryHuanzejiaoyu(Integer id) {
        return patientMapper.queryHuanzejiaoyu(id);
    }

    @Override
    public General queryHuanzheTree(Integer id) {
        return patientMapper.queryHuanzheTree(id);
    }

    @Override
    public void addShoucang(General general) {
        patientMapper.addShoucang(general);
    }

    @Override
    public Oder fsYouxiang(String id) {
        return patientMapper.fsYouxiang(id);
    }

    @Override
    public void updatePeople(General general) {
        patientMapper.updatePeople(general);
    }
}
