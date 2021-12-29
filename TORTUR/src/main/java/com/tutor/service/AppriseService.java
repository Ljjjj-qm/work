package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Apprise;

import java.util.List;

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

    /**
     *
     * @Author: ZhangQingMin
     * 分页获取评价列表
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    List<Apprise> getAppriseListByPage(Integer pageNum, Integer pageSize);

    /**
     *
     * @Author ZhangQingMin
     * @param query 辅导员id
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    List<Apprise> getAppriseListByTutorId(Integer query, Integer pageNum, Integer pageSize);

    /**
     *
     * @Author ZhangQingMin
     * @param query 辅导员id
     * @param pageNum 分页页码
     * @param pageSize 分页大小
     * @return
     */
    List<Apprise> getAppriseListByStudentId(Integer query, Integer pageNum, Integer pageSize);
}
