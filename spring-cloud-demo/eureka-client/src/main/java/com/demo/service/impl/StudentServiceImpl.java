package com.demo.service.impl;

import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * Created by Yinevg on 2020/4/15
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Student get(int id) {
        return new Student(id, "Mike", 21);
    }
}
