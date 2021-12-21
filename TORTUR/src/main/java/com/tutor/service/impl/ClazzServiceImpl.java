package com.tutor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Clazz;
import com.tutor.mapper.ClazzMapper;
import com.tutor.service.ClazzService;
import org.springframework.stereotype.Service;

/**
 * @program: TORTUR
 * @description: Clazz服务层
 * @author: ZhangQingMin
 * @create: 2021-12-21 20:42
 **/
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
}
