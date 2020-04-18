package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Yinevg on 2020/4/18
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker // 声明启动数据监控
@EnableHystrixDashboard // 声明可视化数据监控
public class HystrixApplication {
    // http://localhost:8060/actuator/hystrix.stream
    // http://localhost:8060/hystrix
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}
