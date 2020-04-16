package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Yinevg on 2020/4/15
 */
@SpringBootApplication
public class ProviderApplication2 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProviderApplication2.class);
        springApplication.setAdditionalProfiles("two");
        springApplication.run(args);
    }
}
