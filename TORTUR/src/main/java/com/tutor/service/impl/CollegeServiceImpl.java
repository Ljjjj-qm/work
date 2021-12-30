package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.College;
import com.tutor.mapper.CollegeMapper;
import com.tutor.service.CollegeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {
    @Override
    public List<College> getCollegeList(Integer padeNum, int pageSize) {
        Page<College> page = new Page<>(padeNum, pageSize);
        QueryWrapper<College> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<College> selectPage = baseMapper.selectPage(page, wrapper);
        return selectPage.getRecords();
    }

    @Override
    public String collegeInsert(College entity, BindingResult result, RedirectAttributes attributes) {
        College one = super.getOne(new QueryWrapper<College>().eq("name", entity.getName()));
        if (one != null) {
            result.rejectValue("name", "nameError", "学院名字不能重复");
        }
        if (result.hasErrors()) {
            return "test";
        }
        if (super.save(entity)) {
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/college_list";
    }

    @Override
    public String collegeUpdate(College entity, BindingResult result, RedirectAttributes attributes) {
        College one = super.getOne(new QueryWrapper<College>().eq("name", entity.getName()));
        if (!one.getId().equals(entity.getId())) {
            result.rejectValue("name", "nameError", "学院名字不能重复");
        }
        if (result.hasErrors()) {
            return "test";
        }
        if (super.updateById(entity)) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/college_list";
    }

    @Override
    public String collegeDelete(Integer id, RedirectAttributes attributes) {
        if (super.removeById(id)) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("message", "删除失败");
        }
        return "redirect:/admin/college_list";
    }
}
