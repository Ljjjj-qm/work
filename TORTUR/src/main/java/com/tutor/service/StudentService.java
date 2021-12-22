package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Student;

import java.util.List;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:20:53
 */
public interface StudentService extends IService<Student> {
    List<Student> getStudentList(Integer padeNum, int pageSize);


    //    修改学生
    int  updateStudent(Student student);
    //    添加学生
    int  inserOneStudent(Student student);

    //    删除学生
    int   deleteStudentById(Integer id);
    //    查询学生
    Student   selectStudent(Integer userId);
}
