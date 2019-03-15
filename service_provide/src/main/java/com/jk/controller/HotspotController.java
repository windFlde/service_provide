package com.jk.controller;

import com.jk.bean.Hotspot;
import com.jk.bean.ShouCang;
import com.jk.bean.User;
import com.jk.service.HotspotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("rdzx")
public class HotspotController {

    @Resource
    private HotspotService hotspotService;

    @RequestMapping("queryHotspot")
    public List<Hotspot> queryHotspot(Integer page, Integer rows) {

        List<Hotspot> list=hotspotService.queryHotspot(page,rows);
        return list;

    }

    @RequestMapping("queryHotspotChildren")
    public Hotspot queryHotspotChildren(Hotspot hotspot) {

        Hotspot hotspot1 = hotspotService.queryHotspotChildren(hotspot);
        return hotspot1;

    }




    @RequestMapping("updateRdzxOne")
    public void updateRdzxOne(Integer id) {

        hotspotService.updateRdzxOne(id);

    }

    /**
     * 收藏
     */
    @RequestMapping("addShoucang")
    public String addShoucang(ShouCang shouCang,HttpSession session) {

        User user= (User) session.getAttribute("user");
        if (user == null) {

            return "0";
        }else{

            boolean b=hotspotService.querysc(shouCang.getTitle());
            System.out.println(b);
            if (b) {
                return "2";

            }else{

                shouCang.setUserId(user.getId());

                hotspotService.addShoucang(shouCang);
                return "1";
            }

        }

    }
}
