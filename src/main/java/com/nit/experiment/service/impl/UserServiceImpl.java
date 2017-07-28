package com.nit.experiment.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nit.experiment.common.util.ExcelUtil;
import com.nit.experiment.dao.UserMapper;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public User queryUser(UserLoginDTO user) {
        return userMapper.queryUserByUsernameAndPassword(user);
    }

    public List<User> searchAllUsers(int page, int pageSize, String searchKey, String orderColumn, String orderType){
        PageHelper.startPage(page, pageSize);
        return userMapper.selectAllUsers(searchKey, orderColumn, orderType);
    }

    @Override
    public int deleteOneUser(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User findUserByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateMemberRole(Integer userId, String role) {
        return userMapper.updateMemberRoleByPrimaryKey(userId, role);
    }

    @Override
    public int addMemberByExcel(InputStream in){
        List<User> memberList = null;
        try {
            memberList = ExcelUtil.readMember(in);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMapper.addMemberByExcel(memberList);
    }
}
