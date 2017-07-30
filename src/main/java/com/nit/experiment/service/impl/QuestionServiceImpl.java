package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.dao.QuestionMapper;
import com.nit.experiment.dto.QuestionListDTO;
import com.nit.experiment.entity.Question;
import com.nit.experiment.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 江建平 on 2017/7/28.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<QuestionListDTO> searchAllQuestions(int page, int pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        return questionMapper.selectAllQuestions(searchKey, orderColumn, orderType);
    }

    @Override
    public int deleteQuestionByPrimaryKey(Integer questionId) {
        return questionMapper.deleteByPrimaryKey(questionId);
    }
}
