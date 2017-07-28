package com.nit.experiment.common.dao;

import com.nit.experiment.entity.User;

import java.io.Serializable;

/**
 * Created by 江建平 on 2017/7/22.
 */
public interface BaseMapper<T, ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
