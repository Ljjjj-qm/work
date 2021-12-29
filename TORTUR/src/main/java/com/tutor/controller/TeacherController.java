package com.tutor.controller;


import com.tutor.entity.Teacher;
import com.tutor.service.TeacherService;
import com.tutor.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/teacher")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    /**
     * 1、添加教师
     */
    @PostMapping("/addTeacher")
    public R addTeacher(Teacher teacher){
        boolean flog = teacherService.save(teacher);
        if (flog){
            return R.ok();
        }else {
            return R.error();
        }
    }


    /**
     * 2、根据id删除教师
     */
    @DeleteMapping("deleteTeacherById")
    public R deleteTeacherById(Integer id){
        boolean flog = teacherService.removeById(id);
        if (flog){
            return R.ok();
        }else {
            return R.error();
        }
    }


    /**
     * 3、根据id查询教师信息
     */
    @GetMapping("findTeacherById")
    public R findTeacherById(Integer id){
       Teacher teacher =  teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    /**
     * 4、修该教师信息
     */
    @PostMapping("updateTeacher")
    public R updateTeacher(Teacher teacher){
       boolean flog =  teacherService.updateById(teacher);
       if (flog){
           return R.ok();
       }else{
           return R.error();
       }
    }

    /**
     * 5、查询所有教师信息
     */
    @GetMapping("/findAllTeacher")
    public R findAllTeacher(){
        List<Teacher> teacherList = teacherService.list(null);
        return R.ok().data("teacherList",teacherList);
    }

}

