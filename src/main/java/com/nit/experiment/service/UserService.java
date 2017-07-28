package com.nit.experiment.service;

import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/22.
 */
public interface UserService {
    /**
     * 查询用户
     * @param user
     * @return
     */
    User queryUser(UserLoginDTO user);

    /**
     * 查找所有用户
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<User> searchAllUsers(int page, int pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 删除某个用户
     * @param userId
     * @return
     */
    int deleteOneUser(Integer userId);

    /**
     * 根据主键查找用户
     * @param userId
     * @return
     */
    User findUserByPrimaryKey(Integer userId);

    /**
     * 修改成员角色
     * @param userId
     * @param role
     * @return
     */
    int updateMemberRole(Integer userId, String role);

    int addMemberByExcel(InputStream in);
}
