package com.jk.client;

import com.jk.bean.Example;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("search")
public interface SearchClient {

    @RequestMapping("getTitle")
    List<Example> getTitle(@RequestParam(value = "name") String name);
}
