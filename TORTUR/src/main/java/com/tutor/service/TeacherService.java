package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {

    List<Teacher> getTeacherList(Integer padeNum, int pageSize);

}
