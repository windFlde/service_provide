package com.jk.service.impl;

import com.jk.service.CreateLightService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CreateLightServiceImpl implements CreateLightService {

    @Resource
    private MongoTemplate mongoTemplate;

}
