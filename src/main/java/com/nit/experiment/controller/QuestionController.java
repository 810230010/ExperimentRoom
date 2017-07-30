package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.controller.RestResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import com.nit.experiment.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 查询所有用户
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
    public Object searchAllQuestions( @RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<QuestionListDTO> questionList= questionService.searchAllQuestions(page, pageSize, searchKey, orderColumn, orderType);
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
}
