package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Yinevg on 2020/4/14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    // 访问 http://localhost:8761/
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
