package com.nit.experiment.controller;

import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.qiniu.QiniuUtil;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 江建平 on 2017/8/4.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    /**
     * 个人信息编辑
     * @param model
     * @return
     */
    @RequestMapping("/profileEditPage")
    public String view2profileEdit(Model model){
        model.addAttribute("uploadToken", QiniuUtil.getUploadToken());
        model.addAttribute("baseUrl", QiniuUtil.getBaseUrl());
        return "profile/profile_edit";
    }

    /**
     * 修改个人基本信息
     * @param user
     * @return
     */
    @RequestMapping("/updateBasicProfile")
    @ResponseBody
    public Object updateBasicProfile(User user){
        RestResult result = new RestResult();
        int affectedRow = profileService.updateBasicProfile(user);
        return result;
    }

    /**
     * 跳转到更改密码页面
     * @return
     */
    @RequestMapping("/updatePasswordPage")
    public String view2changePasswordPage(){
        return "profile/password_edit";
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping("/changePassword")
    @ResponseBody
    public Object changePassword(Integer userId, String password){
        RestResult result = new RestResult();
        int affectedRow = profileService.changePassword(userId, password);
        return result;
    }
}
