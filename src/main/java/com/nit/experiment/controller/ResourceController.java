package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.dto.ResourceListDTO;
import com.nit.experiment.entity.Resource;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 江建平 on 2017/9/20.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @RequestMapping("/resourceAreaPage")
    public String view2resourcearea(){
        return "learning_resource/resource_area";
    }

    /**
     * 资源列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchAllResource")
    @ResponseBody
    public Object searchAllUsers( @RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<ResourceListDTO> resourceList= resourceService.searchAllResource(page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<ResourceListDTO>(resourceList, draw);
    }
}
