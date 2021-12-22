package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.mapper.StudentMapper;
import com.tutor.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public List<Student> getStudentList(Integer padeNum, int pageSize) {
        Page<Student> page = new Page<>(padeNum, pageSize);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<Student> selectPage = baseMapper.selectPage(page, wrapper);
        return selectPage.getRecords();
    }

}
