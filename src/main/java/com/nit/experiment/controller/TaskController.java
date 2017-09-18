package com.nit.experiment.controller;

import com.nit.experiment.common.controller.PageResult;
import com.nit.experiment.common.util.StringUtils;
import com.nit.experiment.dto.MyTaskDTO;
import com.nit.experiment.entity.User;
import com.nit.experiment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/9/18.
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 跳转到任务大厅
     * @return
     */
    @RequestMapping("/addTaskPage")
    public String view2addTasks(){
        return "task/task_add";
    }
    /**
     * 根据状态查询我的任务
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param state
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchMyTasksWithStatus/{state}")
    @ResponseBody
     public Object searchMytasksWithStatus(@RequestParam("draw") int draw,
                                           @RequestParam(value = "searchKey", required = false) String searchKey,
                                           @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                           @RequestParam(value = "orderType", required = false) String orderType,
                                           @PathVariable(value="state") Integer state,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                           HttpServletRequest request){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<MyTaskDTO> taskList= taskService.searchTasksWithStatus(request,state, page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<MyTaskDTO>(taskList, draw);
     }
}
