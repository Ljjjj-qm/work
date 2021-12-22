package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.entity.Teacher;
import com.tutor.mapper.TeacherMapper;
import com.tutor.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public List<Teacher> getTeacherList(Integer padeNum, int pageSize) {
        Page<Teacher> page = new Page<>(padeNum, pageSize);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<Teacher> selectPage = baseMapper.selectPage(page, wrapper);
        return selectPage.getRecords();
    }

}
