package com.nit.experiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 江建平 on 2017/9/20.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @RequestMapping("/resourceAreaPage")
    public String view2resourcearea(){
        return "learning_resource/resource_area";
    }
}
