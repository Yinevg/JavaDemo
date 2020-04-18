package com.demo.feign;

import com.demo.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Yinevg on 2020/4/18
 */
@FeignClient(value = "provider")
public interface FeignProviderClient {

    @GetMapping("/student/get/{id}")
    Student get(@PathVariable("id") int id);

    @GetMapping("/student/index")
    String getPort();
}
