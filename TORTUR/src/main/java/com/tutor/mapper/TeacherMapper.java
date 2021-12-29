package com.tutor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutor.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    Integer selectTeacherIdByName(String teacherName);
}
