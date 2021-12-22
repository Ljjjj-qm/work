package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Clazz;

import java.util.List;

/**
 * @program: TORTUR
 * @description: 管理员Service层，管理员逻辑代码在里面编写
 * @author: ZhangQingMin
 * @create: 2021-12-21 16:44
 **/
public interface ClazzService extends IService<Clazz> {

    List<Clazz> getClazzListByPage(Integer pageNum, Integer pageSize);
}
