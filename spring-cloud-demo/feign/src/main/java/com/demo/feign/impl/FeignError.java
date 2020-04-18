package com.demo.feign.impl;

import com.demo.entity.Student;
import com.demo.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

/**
 * Created by Yinevg on 2020/4/18
 * 服务熔断实现类，需要在FeignClient注解中指定
 */
@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public String getPort() {
        return "服务器维护中";
    }
}
