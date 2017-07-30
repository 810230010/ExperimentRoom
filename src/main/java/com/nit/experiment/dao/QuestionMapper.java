package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
