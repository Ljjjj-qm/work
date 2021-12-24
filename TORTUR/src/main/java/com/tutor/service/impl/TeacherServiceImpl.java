package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.entity.Teacher;
import com.tutor.mapper.TeacherMapper;
import com.tutor.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public List<Teacher> getTeacherList(Integer padeNum, int pageSize) {
        Page<Teacher> page = new Page<>(padeNum, pageSize);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<Teacher> selectPage = baseMapper.selectPage(page, wrapper);
        return selectPage.getRecords();
    }

    @Override
    public String teacherInsert(Teacher entity, BindingResult result, RedirectAttributes attributes) {
        Teacher one = super.getOne(new QueryWrapper<Teacher>().eq("user_id", entity.getUserId()));
        if (one != null) {
            result.rejectValue("name", "nameError", "userId不能重复");
        }
        if (result.hasErrors()) {
            return "test";
        }
        if (super.save(entity)) {
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/teacher_list";
    }

    @Override
    public String teacherUpdate(Teacher entity, BindingResult result, RedirectAttributes attributes) {
        Teacher one = super.getOne(new QueryWrapper<Teacher>().eq("user_id", entity.getUserId()));
        if (!one.getId().equals(entity.getId())) {
            result.rejectValue("name", "nameError", "userId不能重复");
        }
        if (result.hasErrors()) {
            return "test";
        }
        if (super.updateById(entity)) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/teacher_list";
    }

    @Override
    public String teacherDelete(Integer id, RedirectAttributes attributes) {
        if (super.removeById(id)) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("message", "删除失败");
        }
        return "redirect:/admin/teacher_list";
    }

}
