package com.tutor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tutor.entity.Tutor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TutorMapper extends BaseMapper<Tutor> {
}
