package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.qiniu.QiniuUtil;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/28.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    private static Logger logger = Logger.getLogger(QuestionController.class);
    @Autowired
    private QuestionService questionService;
    /**
     * 问题列表页面
     * @return
     */
    @RequestMapping("/questionListPage")
    public String view2questionList(){
        return "discussion/question_list";
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
    @RequestMapping("/searchAllQuestions")
    @ResponseBody
    public Object searchAllQuestions(@RequestParam("draw") int draw,
                                     @RequestParam(value = "searchKey", required = false) String searchKey,
                                     @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                     @RequestParam(value = "orderType", required = false) String orderType,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     HttpServletRequest request){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<QuestionListDTO> questionList= questionService.searchAllQuestions(page, pageSize, searchKey, orderColumn, orderType, request);
        return new PageResult<QuestionListDTO>(questionList, draw);
    }

    /**
     * 删除问题
     * @param questionId
     * @return
     */
    @RequestMapping("/delete/{questionId}")
    @ResponseBody
    public Object deleteOneQuestion(@PathVariable Integer questionId){
        RestResult result = new RestResult();
        int affectedRow = questionService.deleteQuestionByPrimaryKey(questionId);
        return result;
    }

    /**
     * 更改点赞状态
     * @param userId
     * @param questionId
     * @param targetStatus 0:取消点赞  1:点赞
     * @return
     */
    @RequestMapping("/thumbup")
    @ResponseBody
    public Object thumbup(Integer userId, Integer questionId, Integer targetStatus){
        RestResult result = new RestResult();
        int affectedRow = questionService.updateThumbupStatus(userId, questionId, targetStatus);
        return result;
    }

    /**
     * 收藏问题
     * @param userId
     * @param questionId
     * @param targetStatus  0:取消收藏 1:收藏
     * @return
     */
    @RequestMapping("/collect")
    @ResponseBody
    public Object collectQuestion(Integer userId, Integer questionId, Integer targetStatus){
        RestResult result = new RestResult();
        questionService.updateQuestionCollectedStatus(userId, questionId, targetStatus);
        return result;
    }

    /**
     * 问题详情页面
     * @param model
     * @param questionId
     * @return
     */
    @RequestMapping("/questionDetailPage")
    public String view2questionDetail(Model model, Integer questionId){
        model.addAttribute("question", questionService.getQuestionDetailWithReply(questionId));
        model.addAttribute("uploadToken", QiniuUtil.getUploadToken());
        model.addAttribute("domain", QiniuUtil.getBaseUrl());
        return "/discussion/question_detail";
    }

    /**
     * 跳转到添加问题页面
     * @param model
     * @return
     */
    @RequestMapping("/addQuestionPage")
    public String view2addQuestion(Model model){
        model.addAttribute("uploadToken", QiniuUtil.getUploadToken());
        model.addAttribute("domain", QiniuUtil.getBaseUrl());
        return "discussion/add_question";
    }

    /**
     * 添加问题
     * @param question
     * @return
     */
    @RequestMapping("/addQuestion")
    @ResponseBody
    public Object addQuestion(Question question){
        RestResult result = new RestResult();
        int affectedRow = questionService.addQuestion(question);
        return result;
    }
}
