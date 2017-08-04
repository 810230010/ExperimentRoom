package com.nit.experiment.service;

import com.nit.experiment.entity.User;

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
}
