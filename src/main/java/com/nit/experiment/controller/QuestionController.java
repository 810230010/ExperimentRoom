package com.nit.experiment.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 江建平 on 2017/7/28.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    private static Logger logger = Logger.getLogger(QuestionController.class);
    /**
     * 问题列表页面
     * @return
     */
    @RequestMapping("/questionListPage")
    public String view2questionList(){
        return "discussion/question_list";
    }
}
