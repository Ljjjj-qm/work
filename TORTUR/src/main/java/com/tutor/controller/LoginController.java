package com.tutor.controller;


import com.tutor.entity.User;
import com.tutor.service.RoleService;
import com.tutor.service.UserRoleService;
import com.tutor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: abc
 * @description: 用户登录控制器
 * @author: ZhangQingMin
 * @create: 2021-04-01 22:10
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserRoleService userRoleService;
//
//    @Autowired
//    private RoleService roleService;

    /**
     * @Description: 跳转登录页面
     * @Auther: ZhangQingMin
     * @Date: 2021-04-01 22:10
     * @Param:
     * @Return: 返回登录页面
     */
    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    /**
     * @Description: 登录校验
     * @Auther: ZhangQingMin
     * @Date: 2021-04-01 22:10
     * @Param: username:用户名
     * @Param: password:密码
     * @Param: session:session域
     * @Param: attributes:返回页面消息
     * @Return: 登录成功跳转首页，登录失败返回登录页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.getUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);

            return "redirect:/";

//            if (user.getIsroot() == '0') {
//                // 向首页添加最近两天通知消息的条数
//
//                Account account = accountService.selectAccountByUserId(user.getId());
//
//                int sum = 0;
//                List<TradeDetial> tradeDetials = tradeDetialService.selectTradeDetialByDays(account.getId());
//                for (TradeDetial tradeDetial : tradeDetials) {
//                    sum++;
//                }
//                redirectAttributes.addFlashAttribute("count", sum);
//                return "redirect:/";
//            } else {
//                return "redirect:/user";
//            }

        } else {
            redirectAttributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/loginPage";
        }
    }

    /**
     * @Description: 注销
     * @Auther: ZhangQingMin
     * @Date: 2021-04-01 22:10
     * @Param: session:session域
     * @Return: 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/loginPage";
    }
}