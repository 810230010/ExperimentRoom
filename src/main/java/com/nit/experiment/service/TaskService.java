package com.nit.experiment.service;

import com.nit.experiment.dto.MyTaskDTO;
import com.nit.experiment.dto.TaskDTO;
import com.nit.experiment.entity.Task;
import com.nit.experiment.entity.TaskAccept;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/9/18.
 */
public interface TaskService {
    /**
     * 查询我的任务
     * @param request
     * @param state
     * @param page
     * @param pageSize
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<MyTaskDTO> searchTasksWithStatus(HttpServletRequest request, Integer state, Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);

    /**
     * 查询所有任务
     * @return
     */
    List<TaskDTO> getAllTasks();

    /**
     * 领取任务
     * @param accept
     * @return
     */
    int add2MyTasks(TaskAccept accept);
}
