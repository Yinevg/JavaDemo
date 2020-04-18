package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Yinevg on 2020/4/18
 */
@SpringBootApplication
@EnableConfigServer
public class RemoteConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RemoteConfigServerApplication.class, args);
    }
}
