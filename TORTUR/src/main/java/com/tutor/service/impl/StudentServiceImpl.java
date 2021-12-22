package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.mapper.StudentMapper;
import com.tutor.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:20:54
 */
@Service
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {

//    添加学生
    public int  inserOneStudent(Student student){
//         根据班级名称查询班级id  根据 辅导员姓名查询辅导员id
       return   baseMapper.insert(student);
    }

//    删除学生
    public  int   deleteStudentById(Integer id){
        return  baseMapper.deleteById(id);
    }

//    查询学生
    public  Student   selectStudent(Integer userId){
        QueryWrapper<Student> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return baseMapper.selectOne(wrapper);
    }

//    修改学生
    public  int  updateStudent(Student student){
       return baseMapper.updateById(student);
    }

}
