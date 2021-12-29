package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.Student;
import com.tutor.entity.Teacher;
import com.tutor.mapper.ClazzMapper;
import com.tutor.mapper.StudentMapper;
import com.tutor.mapper.TeacherMapper;
import com.tutor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @Author : ZQL
 * Date:2021/12/21
 * Time:20:54
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * @Author: ZengQingLong
     * 添加学生个人信息
     * @param teacherName 老师名字
     * @param clazzCode 班级code
     * @param student   学生对象
     */
    @Override
    public String insertOneStudent(Student student,String teacherName,String clazzCode
                                       ,BindingResult result, RedirectAttributes attributes ) {
        if (result.hasErrors()) {
            return "test";
        }
        //         根据班级名称查询班级id  根据 辅导员姓名查询辅导员id
        student.setTutorId(teacherMapper.selectTeacherIdByName(teacherName));
        student.setClassId(clazzMapper.selectClazzIdByClazzCode(clazzCode));
        int insert = baseMapper.insert(student);
        if (insert==1){
            attributes.addFlashAttribute("message","插入信息成功");
        }else {
            attributes.addFlashAttribute("message","插入信息失败");
        }
        return "redirect:/student_list";
    }

    //    删除学生
    @Override
    public int deleteStudentById(Integer id) {
        return baseMapper.deleteById(id);
    }

    //    查询学生
    @Override
    public Student selectStudent(Integer userId) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public String studentInsert(Student entity, BindingResult result, RedirectAttributes attributes) {
        Student one = super.getOne(new QueryWrapper<Student>().eq("user_id", entity.getUserId()));
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
        return "redirect:/admin/student_list";
    }

    @Override
    public String studentUpdate(Student entity, BindingResult result, RedirectAttributes attributes) {
        Student one = super.getOne(new QueryWrapper<Student>().eq("user_id", entity.getUserId()));
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
        return "redirect:/admin/student_list";
    }

    @Override
    public String studentDelete(Integer id, RedirectAttributes attributes) {
        if (super.removeById(id)) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("message", "删除失败");
        }
        return "redirect:/admin/student_list";
    }

    //    修改学生
    @Override
    public int updateStudent(Student student) {
        return baseMapper.updateById(student);
    }

    @Override
    public List<Student> getStudentList(Integer padeNum, int pageSize) {
        Page<Student> page = new Page<>(padeNum, pageSize);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<Student> selectPage = baseMapper.selectPage(page, wrapper);
        return selectPage.getRecords();
    }
}
