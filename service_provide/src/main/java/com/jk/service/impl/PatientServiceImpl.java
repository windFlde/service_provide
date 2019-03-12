package com.jk.service.impl;

import com.jk.bean.General;
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
}
