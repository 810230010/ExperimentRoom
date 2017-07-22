package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseDao;
import com.nit.experiment.entity.User;

public interface UserMapper extends BaseDao<User>{
    User queryUserByUsernameAndPassword(User user);
}