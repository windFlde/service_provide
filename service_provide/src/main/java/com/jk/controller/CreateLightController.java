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
        arr.add(createLight.getS5c810fb89d72722fdcecef65());
        arr.add(createLight.getS5c81149d9d72722fdcecef66());
        arr.add(createLight.getS5c8114c49d72722fdcecef67());
        arr.add(createLight.getS5c8114cc9d72722fdcecef68());
        arr.add(createLight.getS5c8114cc9d72722fdcecef69());
        arr.add(createLight.getS5c8114cd9d72722fdcecef6a());
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
