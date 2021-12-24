package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Student;
import com.tutor.entity.Teacher;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Year;
import java.util.List;

public interface TeacherService extends IService<Teacher> {

    List<Teacher> getTeacherList(Integer padeNum, int pageSize);

    String teacherInsert(Teacher entity, BindingResult result, RedirectAttributes attributes);

    String teacherUpdate(Teacher entity, BindingResult result, RedirectAttributes attributes);

    String teacherDelete(Integer id, RedirectAttributes attributes);
}
