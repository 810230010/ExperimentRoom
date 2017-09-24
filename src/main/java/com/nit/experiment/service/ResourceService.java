package com.nit.experiment.service;

import com.nit.experiment.dto.ResourceListDTO;

import java.util.List;

/**
 * Created by 江建平 on 2017/9/20.
 */
public interface ResourceService {
    /**
     * 查询所有资源
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<ResourceListDTO> searchAllResource(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);
}
