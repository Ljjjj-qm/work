package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Apprise;
import com.tutor.entity.Clazz;
import com.tutor.mapper.AppriseMapper;
import com.tutor.service.AppriseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:21:31
 */
@Service
public class AppriseServiceImpl  extends ServiceImpl<AppriseMapper, Apprise> implements AppriseService {

    /**
     * @Author: ZengQingLong
     * 学生对老师做出评价
     * @param teacherId 老师id
     * @param studentId 学生id
     * @param apprise   学生评价对象
     */
    @Override
    public String  setApprisefortutor(Integer  teacherId,Integer studentId, Apprise apprise,BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return "test";
        }
        apprise.setTutorId(teacherId);
        apprise.setStudentId(studentId);
        apprise.setAppriseTime(new Date());
        apprise.setReceived(0);
        apprise.setCompleted(0);
        int insert = baseMapper.insert(apprise);
        if (insert==1) {
            attributes.addFlashAttribute("message", "添加评价成功");
        } else {
            attributes.addFlashAttribute("message", "添加评价失败");
        }
        return  "redirect: /apprise_list";
    }

    /**
     * @Author: ZengQingLong
     * @param前端传入学生id
     * @return 返回学生的评价
     */
    @Override
    public String  selectAppriseByStudentId(Integer studentId, BindingResult result, RedirectAttributes attributes){
       if(result.hasErrors()){
           return  "test";
       }
        QueryWrapper<Apprise> wrapper = new QueryWrapper<Apprise>().eq("student_id", studentId);
        Apprise apprise = baseMapper.selectOne(wrapper);
        attributes.addAttribute("apprise",apprise);
        return "redirect:/apprise_list";
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
