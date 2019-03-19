package com.jk.controller;

import com.jk.bean.AnswerKey;
import com.jk.bean.CreateLight;
import com.jk.service.CreateLightService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cg")
public class CreateLightController {

    //1
    @Resource
    private CreateLightService createLightService;

    @Resource
    private MongoTemplate mongoTemplate;

    @ResponseBody
    @RequestMapping("insertCreateLight")
    public String insertPerson(CreateLight per) {
        mongoTemplate.save(per);
        return "1";
    }
    @ResponseBody
    @RequestMapping("insertAnswer")
    public String insertAnswer(AnswerKey per) {
        mongoTemplate.save(per);
        return "1";
    }
    @ResponseBody
    @RequestMapping("selectMongoDbToDb")
    public List<CreateLight> selectMongoDbToDb(String id) {
        List<CreateLight> person = mongoTemplate.find(null, CreateLight.class);
        return person;
    }

    List<CreateLight> listFf = null;

    @ResponseBody
    @RequestMapping("getListFf")
    public List<CreateLight>getListFf() {
            return listFf;
    }

    @ResponseBody
    @RequestMapping("queryTtOrFf")
    public Integer queryTtOrFf(CreateLight createLight, HttpSession session) {
        List arr = new ArrayList();
        arr.add(createLight.getS5c90590a9d727208e4036a1c());
        arr.add(createLight.getS5c90595e9d727208e4036a1d());
        arr.add(createLight.getS5c9059979d727208e4036a1e());
        arr.add(createLight.getS5c9059af9d727208e4036a1f());
        arr.add(createLight.getS5c9059b49d727208e4036a20());
        arr.add(createLight.getS5c9059c29d727208e4036a21());
        int count = 0;
        listFf = new ArrayList<>();
        List<CreateLight>listFromDb=mongoTemplate.find(null,CreateLight.class);

        for (int i =0;i<6;i++){
            if (listFromDb.get(i).getAnswerKey().equals(arr.get(i))) {
                count++;
            }else{
                String id = listFromDb.get(i).getId();

                listFf.add(listFromDb.get(i));
                session.setAttribute("listFf",listFf);
            }
        }
            return count;
    }

}
