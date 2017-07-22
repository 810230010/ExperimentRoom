package com.nit.experiment.service.impl;

import com.nit.experiment.dao.UserMapper;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 江建平 on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户
     * @param user
     * @return
     */
    public boolean queryUser(User user) {
        if(userMapper.queryUserByUsernameAndPassword(user) != null){
            return true;
        }
        return false;
    }
}
