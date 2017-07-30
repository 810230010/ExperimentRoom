package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 江建平 on 2017/7/28.
 */
public interface QuestionMapper extends BaseMapper<Question, Integer>{
    /**
     * 条件查询所有问题
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<QuestionListDTO> selectAllQuestions(@Param("searchKey") String searchKey,
                                             @Param("orderColumn") String orderColumn,
                                             @Param("orderType") String orderType);

    /**
     * 查询当前用户对于问题的操作情况(收藏、点赞等)
     * @param userId
     * @param questionId
     * @return
     */
    HashMap<String, Boolean> queryUserWithQuestionOperation(@Param("userId") Integer userId, @Param("questionId") Integer questionId);

    /**
     * 更新点赞状态
     * @param userId
     * @param questionId
     * @param targetStatus
     * @return
     */
    int updateThumbup(@Param("userId") Integer userId, @Param("questionId") Integer questionId, @Param("targetStatus")Integer targetStatus);

    /**
     * 查询t_user_question是否存在某条记录
     * @param userId
     * @param questionId
     * @return
     */
    int existenceOfUserQuestion(@Param("userId") Integer userId, @Param("questionId") Integer questionId);

    /**
     * 插入一条记录到t_user_question
     * @param userId
     * @param questionId
     * @return
     */
    int insertUserQuestion(@Param("userId") Integer userId, @Param("questionId") Integer questionId);
}
