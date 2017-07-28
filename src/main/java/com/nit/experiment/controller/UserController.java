package com.nit.experiment.controller;


import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;


/**
 * Created by 江建平 on 2017/7/22.
 */
@Controller
@RequestMapping("/user")
class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model, UserLoginDTO user, HttpServletRequest request){
        User result = userService.queryUser(user);
        if(result != null){
            WebUtil.setCurrentUser(request, result);
            return "redirect:/user/index";
        }
        model.addAttribute("msg", "<font color='red'>用户名或密码错误</font>");
        return "forward:/login.jsp";
    }
    /**
     * 实验室首页
     * @return
     */
    @RequestMapping("/index")
    public String view2indexPage(){
        return "index";
    }




    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        WebUtil.logoutUser(request);
        return "redirect:/login.jsp";
    }
}
