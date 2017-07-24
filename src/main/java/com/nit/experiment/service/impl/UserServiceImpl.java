package com.nit.experiment.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nit.experiment.dao.UserMapper;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 江建平 on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public boolean queryUser(UserLoginDTO user) {
        if(userMapper.queryUserByUsernameAndPassword(user) != null){
            return true;
        }
        return false;
    }

    public List<User> searchAllUsers(int page, int pageSize, String searchKey, String orderColumn, String orderType){
        PageHelper.startPage(page, pageSize);
        return userMapper.selectAllUsers(searchKey, orderColumn, orderType);
    }
}
