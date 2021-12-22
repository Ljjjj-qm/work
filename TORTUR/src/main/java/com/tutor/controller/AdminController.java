package com.tutor.controller;

import com.tutor.entity.Clazz;
import com.tutor.mapper.ClazzMapper;
import com.tutor.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private ClazzMapper clazzMapper;

    /**
     * 分页获取班级列表
     * @param model model数据传输对象
     * @param pageNum 页码
     * @return
     * 控制器链接还没填
     */
    @RequestMapping("/class_list")
    public String getClassList(Model model,
                               @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        // 调用Service层方法获取分页数据
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
}
