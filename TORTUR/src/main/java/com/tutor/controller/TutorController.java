package com.tutor.controller;


import com.tutor.entity.Apprise;
import com.tutor.entity.Tutor;
import com.tutor.service.AppriseService;
import com.tutor.service.TutorService;
import com.tutor.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XUN~MLF
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/tutor")
public class
TutorController {

    @Autowired
    private TutorService tutorService;
    private AppriseService appriseService;


    /**
     * 1、查询所有辅导员信息
     * @return
     */
    @GetMapping("/findAllTutor")
    public R findAllTutor(){
        List<Tutor> tutorList = tutorService.list(null);
        return R.ok().data("tutorList",tutorList);
    }


    /**
     * 2、添加辅导员信息
     * @param tutor
     * @return
     */
    @PostMapping("/addTutor")
    public R addTutor(Tutor tutor){
        boolean flog = tutorService.save(tutor);
        if (flog){
            return  R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 3、根据删除辅导员信息
     */
    @PostMapping("/deleteTutor")
    public R deleteTutor(Integer id){
        boolean flog = tutorService.removeById(id);
        if (flog){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 4、根据id查询辅导员信息
     */
    @GetMapping("/findTutorById")
    public R findTutorById(Integer id){
        Tutor tutor = tutorService.getById(id);
        return R.ok().data("tutor",tutor);
    }

    /**
     * 5、修该辅导员信息
     */
    @PostMapping("updateTutor")
    public R updateTutor(Tutor tutor){
        boolean flog = tutorService.updateById(tutor);
        if (flog){
            return R.ok();
        }else {
            return R.error();
        }
    }


}

