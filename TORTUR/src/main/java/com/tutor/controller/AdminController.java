package com.tutor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tutor.entity.Apprise;
import com.tutor.entity.Clazz;
import com.tutor.entity.Student;
import com.tutor.entity.Teacher;
import com.tutor.service.AppriseService;
import com.tutor.service.ClazzService;
import com.tutor.service.StudentService;
import com.tutor.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: TORTUR
 * @description: 管理员端控制器
 * @author: ZhangQingMin
 * @create: 2021-12-21 16:44
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private AppriseService appriseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    //******************************************学生管理*********************************************

    /**
     * 获取学生分页列表
     *
     * @param model   数据传输对象
     * @param padeNum 页码
     * @return 页面链接
     */
    @RequestMapping("/student_list")
    public String getStudentList(Model model, @RequestParam(defaultValue = "1", value = "padeNum") Integer padeNum) {
        List<Student> students = studentService.getStudentList(padeNum, 10);
        model.addAttribute("data", students);
        return "test";
    }

    @PostMapping("/studentInsert")
    public String studentInsert(@RequestBody Student entity, BindingResult result, RedirectAttributes attributes) {
        return studentService.studentInsert(entity, result, attributes);
    }

    @PostMapping("/studentUpdate")
    public String studentUpdate(@RequestBody Student entity, BindingResult result, RedirectAttributes attributes) {
        return studentService.studentUpdate(entity, result, attributes);
    }

    @DeleteMapping("/studentDelete/{id}")
    public String studentDelete(@PathVariable Integer id, RedirectAttributes attributes) {
        return studentService.studentDelete(id, attributes);
    }

    //******************************************老师管理*********************************************

    /**
     * 获取老师分页列表
     *
     * @param model   数据传输对象
     * @param padeNum 页码
     * @return 页面链接
     */
    @RequestMapping("/teacher_list")
    public String getTeacherList(Model model, @RequestParam(defaultValue = "1", value = "padeNum") Integer padeNum) {
        List<Teacher> teacherList = teacherService.getTeacherList(padeNum, 10);
        model.addAttribute("data", teacherList);
        return "test";
    }

    @PostMapping("/teacherInsert")
    public String teacherInsert(@RequestBody Teacher entity, BindingResult result, RedirectAttributes attributes) {
        return teacherService.teacherInsert(entity, result, attributes);
    }

    @PostMapping("/teacherUpdate")
    public String teacherUpdate(@RequestBody Teacher entity, BindingResult result, RedirectAttributes attributes) {
        return teacherService.teacherUpdate(entity, result, attributes);
    }

    @DeleteMapping("/teacherDelete/{id}")
    public String teacherDelete(@PathVariable Integer id, RedirectAttributes attributes) {
        return teacherService.teacherDelete(id, attributes);
    }


    // ******************************************班级管理********************************

    /**
     *
     * @description: 分页获取班级列表
     * @author: ZhangQingMin
     * @param model model数据传输对象
     * @param pageNum 页码
     * @return
     * 控制器链接还没填
     */
    @RequestMapping("/class_list")
    public String getClassList(Model model,
                               @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        // 调用Service层方法获取分页数据，pageNum : 分页页码, pageSize : 分页大小
        List<Clazz> records = clazzService.getClazzListByPage(pageNum, 10);
        // 打印输出
//        for (Clazz clazz : records) {
//            System.out.println(clazz);
//        }
        // 通过model将数据传送给前端
        model.addAttribute("message", records);

        /**
         *  return 页面还未填写
         */
        return "test";
    }

    /**
     *
     * @description: 通过班级号查询班级列表
     * @author: ZhangQingMin
     * @param query 查询参数
     * @param model 数据传输对象
     * @param pageNum 页码
     * @return
     */
    @PostMapping("/class_search")
    public String getClassListByCode(@RequestParam String query, Model model,
                                     @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        // 调用Service层搜索数据
        List<Clazz> clazzList = clazzService.getClazzListByQuery(query, pageNum, 10);
        // 使用model将数据传送给前端，message与前端的 <div th:text="${message}"></div> 相对应
        model.addAttribute("message", clazzList);
        // 调用成功后返回到template下的test.html页面
        return "test";
    }

    /**
     *
     * @description: 删除班级操作
     * @author: ZhangQingMin
     * @param id 班级id
     * @param attributes 重定向参数，类似model
     * @return
     */
    @GetMapping("/class_delete/{id}")
    public String deleteClassById(@PathVariable Long id, RedirectAttributes attributes) {

        // 调用Service方法删除对应id的班级
        boolean b = clazzService.removeById(id);
        if (b) {
            // 删除成功，重定向并发送信息，message2与前端的 <div th:text="${message2}"></div> 相对应
            attributes.addFlashAttribute("message2", "删除成功");
        } else {
            attributes.addFlashAttribute("message2", "删除失败");
        }

        // 重定向到 /admin/class_list 接口下
        return "redirect:/admin/class_list";
    }

    /**
     *
     * @description: 新增班级
     * @author: ZhangQingMin
     * @param clazz 前端传来的clazz对象
     * @param result 用于处理clazz对象的数据校验对象
     * @param attributes 重定向参数
     * @return
     */
    @PostMapping("/class_inset")
    public String insertClass(@Valid Clazz clazz, BindingResult result, RedirectAttributes attributes) {

        // 调用Service查询该班级的编号
        Clazz one = clazzService.getOne(new QueryWrapper<Clazz>().eq("code", clazz.getCode()));

        if (one != null) {
            // 如果结果为空，向前端提供错误信息 下面这段信息是前端接收该信息的代码快
//                        <!--/*/
//            <div class="ui negative message" th:if="${#fields.hasErrors('name')}">
//                <i class="close icon"></i>
//                <div class="header">验证失败</div>
//                <p th:errors="*{name}"></p>
//            </div>
//            /*/-->
            result.rejectValue("name", "nameError", "班级代码不能重复");
        }
        if (result.hasErrors()) {
            // 如果BindResult中校验到clazz对象有错误，返回到班级新增页，重新添加，这里用test页代替
            return "test";
        }

        // 调用Service层保存班级
        boolean save = clazzService.save(clazz);
        if (save) {
            // 保存成功，返回信息
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        // 保存成功后，重定向到 /admin/class_list
        return "redirect:/admin/class_list";
    }

    /**
     *
     * @description: 更新班级信息
     * @author: ZhangQingMin
     * @param clazz 前端传来的班级信息
     * @param result 用于处理clazz对象的数据校验对象
     * @param id 携带的班级id
     * @param attributes 重定向对象，相当于model
     * @return
     */
    public String updateClass(@RequestBody @Valid Clazz clazz,
                              BindingResult result,
                              @PathVariable("id") Long id,
                              RedirectAttributes attributes) {

        // 调用Service查询该班级的编号
        Clazz one = clazzService.getOne(new QueryWrapper<Clazz>().eq("code", clazz.getCode()));

        // 判断班级编号是否存在，并做出不同回应
        if (one != null) {
            // 如果结果为空，向前端提供错误信息 下面这段信息是前端接收该信息的代码快
//                        <!--/*/
//            <div class="ui negative message" th:if="${#fields.hasErrors('name')}">
//                <i class="close icon"></i>
//                <div class="header">验证失败</div>
//                <p th:errors="*{name}"></p>
//            </div>
//            /*/-->
            result.rejectValue("name", "nameError", "班级代码不能重复");
        }
        if (result.hasErrors()) {
            // 如果BindResult中校验到clazz对象有错误，返回到班级新增页，重新添加，这里用test页代替
            return "test";
        }

        // 调用Service层更新该id的班级信息
        boolean b = clazzService.update(clazz, new UpdateWrapper<Clazz>().eq("id", id));

        if (b) {
            // 保存成功，返回信息
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }

        // 保存成功后，重定向到 /admin/class_list
        return "redirect:/admin/class_list";
    }


    // ******************************************评价管理********************************

    /**
     * 分页获取评价信息
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/apprise_list")
    public String getAppriseList(Model model,
                               @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        // 调用Service层方法获取分页数据，pageNum : 分页页码, pageSize : 分页大小
        List<Apprise> records = appriseService.getAppriseListByPage(pageNum, 10);
        // 通过model将数据传送给前端
        model.addAttribute("message", records);

        /**
         *  return 页面还未填写
         */
        return "apprise_test";
    }

    /**
     *
     * @description: 查询某个辅导员的评论信息列表
     * @author: ZhangQingMin
     * @param query 查询参数
     * @param model 数据传输对象
     * @param pageNum 页码
     * @return
     */
    @PostMapping("/apprise_search_tutor")
    public String getAppriseListByTutorId(@RequestParam Integer query, Model model,
                                     @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        // 调用Service层搜索数据
        List<Apprise> appriseList = appriseService.getAppriseListByTutorId(query, pageNum, 10);

        // 使用model将数据传送给前端，message与前端的 <div th:text="${message}"></div> 相对应
        model.addAttribute("message", appriseList);
        // 调用成功后返回到template下的test.html页面
        return "test";
    }

    /**
     *
     * @description: 查询某个学生的评论信息列表
     * @author: ZhangQingMin
     * @param query 查询参数
     * @param model 数据传输对象
     * @param pageNum 页码
     * @return
     */
    @PostMapping("/apprise_search_student")
    public String getAppriseListByStudentId(@RequestParam Integer query, Model model,
                                          @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        // 调用Service层搜索数据
        List<Apprise> appriseList = appriseService.getAppriseListByStudentId(query, pageNum, 10);

        // 使用model将数据传送给前端，message与前端的 <div th:text="${message}"></div> 相对应
        model.addAttribute("message", appriseList);
        // 调用成功后返回到template下的test.html页面
        return "test";
    }


    /**
     *
     * @description: 更新评价信息
     * @author: ZhangQingMin
     * @param apprise 前端传来的评价对象
     * @param result 用于处理apprise对象的数据校验对象
     * @param id 携带的班级id
     * @param attributes 重定向对象，相当于model
     * @return
     */
    @PostMapping("/apprise_update")
    public String updateApprise(@RequestBody @Valid Apprise apprise,
                              BindingResult result,
                              @PathVariable("id") Long id,
                              RedirectAttributes attributes) {


        // 调用Service层更新该id的评价信息
        boolean b = appriseService.update(apprise, new UpdateWrapper<Apprise>().eq("id", id));

        if (b) {
            // 保存成功，返回信息
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }

        // 保存成功后，重定向到 /admin/apprise_list
        return "redirect:/admin/apprise_list";
    }


}
