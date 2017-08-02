package com.nit.experiment.service;

import com.nit.experiment.entity.Answer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 江建平 on 2017/8/2.
 */
public interface AnswerService {

    /**
     * 插入回答
     * @param answerContent
     * @param request
     * @return
     */
    int addAnswer(Integer questionId, String answerContent, HttpServletRequest request);

    /**
     * 添加回答的答复
     * @param userId
     * @param questionId
     * @param parentId
     * @param answerer
     * @param answerContent
     * @return
     */
    int addAnswerReply(Integer userId, Integer questionId, Integer parentId, String answerer, String answerContent);
}
