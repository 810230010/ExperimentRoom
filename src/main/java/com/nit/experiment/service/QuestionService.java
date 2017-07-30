package com.nit.experiment.service;

import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/28.
 */
public interface QuestionService {
     /**
      * 查询所有问题
      * @param page
      * @param pageSize
      * @param searchKey
      * @param orderColumn
      * @param orderType
      * @return
      */
     List<QuestionListDTO> searchAllQuestions(int page, int pageSize, String searchKey, String orderColumn, String orderType, HttpServletRequest request);

     /**
      * 删除某个问题
      * @param questionId
      * @return
      */
     int deleteQuestionByPrimaryKey(Integer questionId);

     /**
      * 更新点赞状态
      * @param userId
      * @param questionId
      * @param targetStatus
      * @return
      */
     int updateThumbupStatus(Integer userId, Integer questionId, Integer targetStatus);


}
