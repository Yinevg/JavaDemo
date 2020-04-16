package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Yinevg on 2020/4/16
 */
@EnableZuulProxy // 网关启动类
@EnableAutoConfiguration
public class ZuulApplication {
    // 访问 http://localhost:8030/p/**，能负载均衡
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
