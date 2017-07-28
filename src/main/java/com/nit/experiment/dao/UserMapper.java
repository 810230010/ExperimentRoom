package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.dto.UserLoginDTO;
import com.nit.experiment.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User, Integer> {
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

    /**
     * 修改角色
     * @param userId
     * @param role
     * @return
     */
    int updateMemberRoleByPrimaryKey(@Param("userId") Integer userId, @Param("role") String role);

    /**
     * 批量添加成员
     * @param list
     * @return
     */
    int addMemberByExcel(List<User> list);
}