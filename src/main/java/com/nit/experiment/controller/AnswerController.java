package com.nit.experiment.controller;

import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.entity.Answer;
import com.nit.experiment.service.AnswerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 江建平 on 2017/8/2.
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {
    private static Logger logger = Logger.getLogger(AnswerController.class);
    @Autowired
    private AnswerService answerService;

    /**
     * 回答问题
     * @param answerContent
     * @param questionId
     * @param request
     * @return
     */
    @RequestMapping("/answerQuestion")
    @ResponseBody
    public Object answerQuestion(String answerContent, Integer questionId, HttpServletRequest request){
        RestResult result = new RestResult();
        int affectedRow = answerService.addAnswer(questionId, answerContent, request);
        return result;
    }

    @RequestMapping("/answerReply")
    @ResponseBody
    public Object replyAnswer(Integer parentId,
                              Integer questionId,
                              String replyContent,
                              Integer userId,
                              String answerer){
        RestResult result = new RestResult();
        int affectedRow = answerService.addAnswerReply(userId, questionId, parentId, answerer, replyContent);
        return result;
    }
}
