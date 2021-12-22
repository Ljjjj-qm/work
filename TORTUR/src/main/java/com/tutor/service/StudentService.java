package com.tutor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Student;

public interface StudentService extends IService<Student> {
    Page<Student> listStuInfo(Integer current, Integer limit);
}
