package com.tutor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutor.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {
    Integer selectClazzIdByClazzCode(String clazzName);
}
