package com.tutor.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Clazz;
import com.tutor.mapper.ClazzMapper;
import com.tutor.service.ClazzService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: TORTUR
 * @description: Clazz服务层
 * @author: ZhangQingMin
 * @create: 2021-12-21 20:42
 **/
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {


    /**
     * @description: 分页查询班级列表
     * @author: ZhangQingMin
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    @Override
    public List<Clazz> getClazzListByPage(Integer pageNum, Integer pageSize) {

        // 分页查询 pageNum : 当前页， pageSize ：一页数据条数
        Page<Clazz> clazzPage = new Page<>(pageNum, pageSize);
        // queryWrapper 查询条件，这里查询所有数据，不用做条件查询
        clazzPage = baseMapper.selectPage(clazzPage, null);
        // 获取clazz中的记录
        List<Clazz> records = clazzPage.getRecords();

        // 将记录返回
        return records;
    }
}

