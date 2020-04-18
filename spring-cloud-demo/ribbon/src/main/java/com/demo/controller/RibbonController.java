package com.demo.controller;

import com.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Yinevg on 2020/4/18
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Student get(@PathVariable("id") int id) {
        return restTemplate.getForEntity("http://provider/student/get/{id}", Student.class, id).getBody();
    }

    @GetMapping("/index")
    public String getPort() {
        return restTemplate.getForEntity("http://provider/student/index", String.class).getBody();
    }
}
