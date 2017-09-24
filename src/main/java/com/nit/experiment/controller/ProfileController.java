package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.qiniu.QiniuUtil;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.dto.MyQuestionDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.ProfileService;
import com.nit.experiment.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by 江建平 on 2017/8/4.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private QuestionService questionService;

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

    /**
     * 我的任务页面
     * @return
     */
    @RequestMapping("/myTaskPage")
    public String view2myTaskPage(){
        return "profile/my_task";
    }

    /**
     * 我的问题页面
     * @return
     */
    @RequestMapping("/myQuestionPage")
    public String view2myQuestion(){
        return "profile/my_question";
    }

    /**
     * 查询所有问题
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchMyQuestions")
    @ResponseBody
    public Object searchAllQuestions(@RequestParam("draw") int draw,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                     @RequestParam(value = "orderType", required = false) String orderType,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<MyQuestionDTO> questionList= profileService.searchMyQuestions(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<MyQuestionDTO>(questionList, draw);
    }

    /**
     * 问题详情页面
     * @param model
     * @param questionId
     * @return
     */
    @RequestMapping("/myQuestionDetailPage")
    public String view2questionDetail(Model model, Integer questionId){
        model.addAttribute("question", questionService.getQuestionDetailWithReply(questionId));
        return "/profile/question_detail";
    }

    /**
     * 修改回答采纳状态为已采纳
     * @param answerId
     * @return
     */
    @RequestMapping("/myquestion/chooseBestAnswer")
    @ResponseBody
    public Object chooseBestAnswer(Integer answerId){
        RestResult result = new RestResult();
        int affectedRow = profileService.updateAnswerAcceptState(answerId);
        return result;
    }
}
