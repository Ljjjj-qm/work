package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Apprise;
import com.tutor.entity.Clazz;
import com.tutor.mapper.AppriseMapper;
import com.tutor.service.AppriseService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:21:31
 */
@Service
public class AppriseServiceImpl  extends ServiceImpl<AppriseMapper, Apprise> implements AppriseService {

//    添加评价
    @Override
    public void  setApprisefortutor(Integer  teacherId,Integer studentId,Apprise apprise){
        apprise.setTutorId(teacherId);
        apprise.setStudentId(studentId);
        apprise.setAppriseTime(new Date());
        apprise.setReceived(0);
        apprise.setCompleted(0);
        baseMapper.insert(apprise);
    }

//    查看自己评价信息
    @Override
    public Apprise  selectAppriseByStudentId(Integer studentId){
       return baseMapper.selectOne(new QueryWrapper<Apprise>().eq("student_id",studentId));

    }

    /**
     * @Author: ZhangQingMin
     * 分页获取评价列表
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return 返回评价list
     */
    @Override
    public List<Apprise> getAppriseListByPage(Integer pageNum, Integer pageSize) {

        // 分页查询 pageNum : 页码， pageSize ：一页数据条数
        Page<Apprise> apprisePage = new Page<>(pageNum, pageSize);
        // queryWrapper 查询条件，这里查询所有数据，不用做条件查询
        apprisePage = baseMapper.selectPage(apprisePage, null);
        // 获取page对象中的记录
        List<Apprise> records = apprisePage.getRecords();

        // 将记录返回
        return records;
    }

    /**
     *
     * @Author ZhangQingMin
     * @param query 辅导员id
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    @Override
    public List<Apprise> getAppriseListByTutorId(Integer query, Integer pageNum, Integer pageSize) {
        // 分页查询 pageNum : 当前页， pageSize ：一页数据条数
        Page<Apprise> apprisePage = new Page<>(pageNum, pageSize);
        // queryWrapper 设置查询条件，这里根据query查询
        QueryWrapper<Apprise> clazzQueryWrapper = new QueryWrapper<>();

        clazzQueryWrapper.eq("tutor_id", query);

        // 使用bashMapper 分页查询，apprisePage: 分页参数，clazzQueryWrapper: 查询参数
        apprisePage = baseMapper.selectPage(apprisePage, clazzQueryWrapper);

        // 将查询出的记录返回
        return apprisePage.getRecords();
    }

    /**
     *
     * @Author ZhangQingMin
     * @param query 辅导员id
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    @Override
    public List<Apprise> getAppriseListByStudentId(Integer query, Integer pageNum, Integer pageSize) {
        // 分页查询 pageNum : 当前页， pageSize ：一页数据条数
        Page<Apprise> apprisePage = new Page<>(pageNum, pageSize);
        // queryWrapper 设置查询条件，这里根据query查询
        QueryWrapper<Apprise> clazzQueryWrapper = new QueryWrapper<>();

        clazzQueryWrapper.eq("student_id", query);

        // 使用bashMapper 分页查询，apprisePage: 分页参数，clazzQueryWrapper: 查询参数
        apprisePage = baseMapper.selectPage(apprisePage, clazzQueryWrapper);

        // 将查询出的记录返回
        return apprisePage.getRecords();
    }

}
