package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.College;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface CollegeService extends IService<College> {
    List<College> getCollegeList(Integer padeNum, int pageSize);

    String collegeInsert(College entity, BindingResult result, RedirectAttributes attributes);

    String collegeUpdate(College entity, BindingResult result, RedirectAttributes attributes);

    String collegeDelete(Integer id, RedirectAttributes attributes);
}
