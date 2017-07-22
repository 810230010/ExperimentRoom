package com.nit.experiment.common.dao;

import com.nit.experiment.entity.User;

/**
 * Created by 江建平 on 2017/7/22.
 */
public interface BaseDao<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
