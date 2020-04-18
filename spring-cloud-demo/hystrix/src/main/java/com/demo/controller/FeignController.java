package com.demo.controller;

import com.demo.entity.Student;
import com.demo.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yinevg on 2020/4/18
 */
@RestController
@RequestMapping("/hystrix")
public class FeignController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/get/{id}")
    public Student get(@PathVariable("id") int id) {
        return feignProviderClient.get(id);
    }

    @GetMapping("/index")
    public String getPort() {
        return feignProviderClient.getPort();
    }
}
