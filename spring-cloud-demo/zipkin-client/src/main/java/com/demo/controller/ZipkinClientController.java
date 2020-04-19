package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yinevg on 2020/4/19
 */
@RestController
@RequestMapping("/zipkin-client")
public class ZipkinClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String getPort() {
        return port;
    }
}
