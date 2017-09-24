package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dao.AnswerMapper;
import com.nit.experiment.dao.QuestionMapper;
import com.nit.experiment.dao.UserMapper;
import com.nit.experiment.dto.MyQuestionDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/8/4.
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public int updateBasicProfile(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int changePassword(Integer userId, String password) {
        return userMapper.updatePassword(userId, password);
    }

    @Override
    public List<MyQuestionDTO> searchMyQuestions(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        Integer userId = WebUtil.getCurrentUser(request).getUserId();
        return questionMapper.listMyQuestions(searchKey, orderColumn, orderType,userId);
    }

    @Override
    public int updateAnswerAcceptState(Integer answerId) {
        return answerMapper.updateAnswerAcceptState(answerId);
    }
}
