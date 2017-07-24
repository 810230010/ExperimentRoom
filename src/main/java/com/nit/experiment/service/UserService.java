package com.nit.experiment.service;

import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;

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
    boolean queryUser(UserLoginDTO user);

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
}
