package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.dao.ResourceMapper;
import com.nit.experiment.dto.ResourceListDTO;
import com.nit.experiment.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 江建平 on 2017/9/20.
 * 学习资料区
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public List<ResourceListDTO> searchAllResource(Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        return resourceMapper.listResource(searchKey, orderColumn, orderType);
    }
}
