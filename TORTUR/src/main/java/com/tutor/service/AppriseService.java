package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Apprise;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:21:29
 */
public interface AppriseService extends IService<Apprise> {

    //    添加评价
    void  setApprisefortutor(Integer  teacherId,Integer studentId,Apprise apprise);

    //    查看自己评价信息
    Apprise  selectAppriseByStudentId(Integer studentId);
}
