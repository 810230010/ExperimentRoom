package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseDao;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseDao<User>{
    /**
     * 根据用户名密码查询用户是否存在
     * @param user
     * @return
     */
    User queryUserByUsernameAndPassword(UserLoginDTO user);

    /**
     * 查询所有用户
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<User> selectAllUsers(@Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

}