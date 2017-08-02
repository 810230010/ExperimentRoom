package com.nit.experiment.service.impl;

import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dao.AnswerMapper;
import com.nit.experiment.entity.Answer;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 江建平 on 2017/8/2.
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public int addAnswer(Integer questionId, String answerContent, HttpServletRequest request) {
        Answer answer = new Answer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User currentUser = WebUtil.getCurrentUser(request);
        answer.setAnswerContent(answerContent);
        answer.setAnswerer(currentUser.getUserName());
        answer.setAnswerTime(new Date());
        answer.setUserId(currentUser.getUserId());
        answer.setQuestionId(questionId);
        return answerMapper.insertSelective(answer);
    }

    @Override
    public int addAnswerReply(Integer userId, Integer questionId, Integer parentId, String answerer, String answerContent) {
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setUserId(userId);
        answer.setAnswerTime(new Date());
        answer.setAnswerer(answerer);
        answer.setAnswerContent(answerContent);
        answer.setParentId(parentId);
        return answerMapper.insertSelective(answer);
    }
}
