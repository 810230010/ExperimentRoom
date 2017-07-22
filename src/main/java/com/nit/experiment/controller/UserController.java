package com.nit.experiment.controller;

import com.nit.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 江建平 on 2017/7/22.
 */
@Controller
@RequestMapping("/user")
class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String test1(){
        return "index";
    }
}
