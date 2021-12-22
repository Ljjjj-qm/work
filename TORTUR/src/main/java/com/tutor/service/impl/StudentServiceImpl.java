package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.mapper.StudentMapper;
import com.tutor.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public Page<Student> listStuInfo(Integer current, Integer limit) {
        Page<Student> page = new Page<>(current, limit);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return baseMapper.selectPage(page, wrapper);
    }
}
