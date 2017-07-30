package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dao.QuestionMapper;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import com.nit.experiment.service.QuestionService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 江建平 on 2017/7/28.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    private static Logger logger = Logger.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<QuestionListDTO> searchAllQuestions(int page, int pageSize, String searchKey, String orderColumn, String orderType, HttpServletRequest request) {
        PageHelper.startPage(page, pageSize);
        List<QuestionListDTO> questionList = questionMapper.selectAllQuestions(searchKey, orderColumn, orderType);
        if(questionList == null) return null;
        for(QuestionListDTO questionItem : questionList){
            Integer userId = WebUtil.getCurrentUser(request).getUserId();
            Integer questionId = questionItem.getQuestionId();
            HashMap<String, Boolean> questionOperation = questionMapper.queryUserWithQuestionOperation(userId, questionId);
            questionItem.setCollected(questionOperation == null?false:questionOperation.get("collected"));
            questionItem.setThumbup(questionOperation == null?false:questionOperation.get("thumbup"));
        }
        return questionList;
    }

    @Override
    public int deleteQuestionByPrimaryKey(Integer questionId) {
        return questionMapper.deleteByPrimaryKey(questionId);
    }

    @Override
    public int updateThumbupStatus(Integer userId, Integer questionId, Integer targetStatus) {
        int result = questionMapper.existenceOfUserQuestion(userId, questionId);
        //如果result=1说明该记录已存在，只需更新,否则先插入在更新
        if(result == 1){
            return questionMapper.updateThumbup(userId, questionId, targetStatus);
        }
        //插入一条记录
        questionMapper.insertUserQuestion(userId, questionId);
        //更新点赞
        return questionMapper.updateThumbup(userId, questionId, targetStatus);
    }
}
