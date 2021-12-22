package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    List<Student> getStudentList(Integer padeNum, int pageSize);

}
