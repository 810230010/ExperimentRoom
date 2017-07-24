package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/22.
 */
@Controller
@RequestMapping("/user")
class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model, UserLoginDTO user){
        logger.info(userService.queryUser(user));
        if(userService.queryUser(user)){
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
    public String test1(){
        return "index";
    }

    /**
     * 实验室成员列表页面
     * @return
     */
    @RequestMapping("/memberListPage")
    public String view2MemberListPage(){
        return "member_list";
    }

    /**
     * 查询所有用户
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchAllUsers")
    @ResponseBody
    public Object searchAllUsers( @RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<User> userList= userService.searchAllUsers(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<User>(userList, draw);
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        return null;
    }
}
