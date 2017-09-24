package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.dto.ResourceListDTO;
import com.nit.experiment.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 江建平 on 2017/9/20.
 */
public interface ResourceMapper extends BaseMapper<Resource, Integer> {
    /**
     * 查询资源列表
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<ResourceListDTO> listResource(@Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);
}
