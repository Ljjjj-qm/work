package com.tutor.controller;

import com.tutor.entity.Apprise;
import com.tutor.service.AppriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author : ZQL
 * Date:2021
 * Time:11:31
 */
@Controller
@RequestMapping("/apprise")
public class AppriseController {

    @Autowired
    private AppriseService appriseService;


    /**
     * @Author: ZengQingLong
     * @param前端传入学生id
     * @return 返回学生的评价
     */
    @GetMapping("/getapprise")
    public String  getApprise(@RequestParam("studentId") Integer studentId, BindingResult result, RedirectAttributes attributes){
        return  appriseService.selectAppriseByStudentId(studentId,result,attributes);
    }

    /**
     * @Author: ZengQingLong
     * 学生对老师做出评价
     * @param teacherId 老师id
     * @param studentId 学生id
     * @param apprise   学生评价对象
     */
    @PostMapping("/setapprise")
    public  String  setApprise(@RequestParam("teacherId")Integer teacherId ,@RequestParam("studentId")Integer studentId , @RequestBody Apprise apprise,BindingResult result, RedirectAttributes attributes){
        return  appriseService.setApprisefortutor(teacherId,studentId,apprise,result,attributes);
    }
}
