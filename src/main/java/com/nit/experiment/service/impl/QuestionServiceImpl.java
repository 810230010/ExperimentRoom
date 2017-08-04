package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dao.QuestionMapper;
import com.nit.experiment.dto.AnswerDTO;
import com.nit.experiment.dto.QuestionDetailDTO;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import com.nit.experiment.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
        //如果点赞 +1
        if(targetStatus == 1){
            questionMapper.updateQuestionThumbupStatistic(1, userId, questionId);
        }else{
            questionMapper.updateQuestionThumbupStatistic(-1, userId, questionId);
        }
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

    @Override
    public int updateQuestionCollectedStatus(Integer userId, Integer questionId, Integer targetStatus) {
        int result = questionMapper.existenceOfUserQuestion(userId, questionId);
        //如果result=1说明该记录已存在，只需更新,否则先插入在更新
        if(result == 1){
            return questionMapper.updateQuestionCollectedStatus(userId, questionId, targetStatus);
        }
        //插入一条记录
        questionMapper.insertUserQuestion(userId, questionId);
        //更新点赞
        return questionMapper.updateQuestionCollectedStatus(userId, questionId, targetStatus);
    }

    @Override
    public QuestionDetailDTO getQuestionDetailWithReply(Integer questionId) {
        QuestionDetailDTO question = questionMapper.getQuestionDetail(questionId);
        List<AnswerDTO> rawAnswerList = question.getAnswer();
        List<AnswerDTO> orderedList = handleSubType(rawAnswerList, 0);
        question.setAnswer(orderedList);
        return question;
    }




    /**
     * 生成多级菜单
     *
     * @param answers 要整理的分类项
     * @param id    根节点
     * @return
     */
    public static List<AnswerDTO> handleSubType(List<AnswerDTO> answers, Integer id) {
        List<AnswerDTO> rtnlist = new ArrayList<AnswerDTO>();
        for (AnswerDTO answerDTO : answers) {
            if (answerDTO.getParentId().equals(id)) {
                answerDTO.setAnswerReply(handleSubType(answers, answerDTO.getAnswerId()));
                rtnlist.add(answerDTO);
            }
        }
        return rtnlist;
    }

    @Override
    public int addQuestion(Question question) {
        question.setCreateTime(new Date());
        return questionMapper.insertSelective(question);
    }
}
