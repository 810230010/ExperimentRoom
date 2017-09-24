package com.nit.experiment.service;

import com.nit.experiment.dto.MyQuestionDTO;
import com.nit.experiment.entity.User;

import java.util.List;

/**
 * Created by 江建平 on 2017/8/4.
 */
public interface ProfileService {
    /**
     * 更改基本信息
     * @param user
     * @return
     */
    int updateBasicProfile(User user);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    int changePassword(Integer userId, String password);

    /**
     * 查询我的问题
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<MyQuestionDTO> searchMyQuestions(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    int updateAnswerAcceptState(Integer answerId);
}
