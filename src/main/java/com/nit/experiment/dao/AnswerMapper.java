package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.entity.Answer;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 江建平 on 2017/8/2.
 */
public interface AnswerMapper extends BaseMapper<Answer, Integer> {

    /**
     * 修改回答采纳状态为已采纳
     * @param answerId
     * @return
     */
    int updateAnswerAcceptState(@Param("answerId") Integer answerId);
}
