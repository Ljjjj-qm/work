package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Apprise;
import com.tutor.mapper.AppriseMapper;
import com.tutor.service.AppriseService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:21:31
 */
@Service
public class AppriseServiceImpl  extends ServiceImpl<AppriseMapper, Apprise> implements AppriseService {

//    添加评价
    public void  setApprisefortutor(Integer  teacherId,Integer studentId,Apprise apprise){
        apprise.setTutorId(teacherId);
        apprise.setStudentId(studentId);
        apprise.setAppriseTime(new Date());
        apprise.setReceived(0);
        apprise.setCompleted(0);
        baseMapper.insert(apprise);
    }

//    查看自己评价信息
    public Apprise  selectAppriseByStudentId(Integer studentId){
       return baseMapper.selectOne(new QueryWrapper<Apprise>().eq("student_id",studentId));

    }

}
