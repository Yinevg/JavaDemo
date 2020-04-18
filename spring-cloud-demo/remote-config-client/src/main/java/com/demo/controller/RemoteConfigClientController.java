package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yinevg on 2020/4/18
 */
@RestController
@RequestMapping("/remote-config-client")
public class RemoteConfigClientController {
    @Value("${test-value}")
    private String testValue;

    @GetMapping("/index")
    public String index() {
        return testValue;
    }
}
