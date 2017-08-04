package com.nit.experiment.service.impl;

import com.nit.experiment.dao.UserMapper;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 江建平 on 2017/8/4.
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateBasicProfile(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int changePassword(Integer userId, String password) {
        return userMapper.updatePassword(userId, password);
    }
}
