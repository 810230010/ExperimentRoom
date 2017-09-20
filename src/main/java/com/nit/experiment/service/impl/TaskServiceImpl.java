package com.nit.experiment.service.impl;

import com.github.pagehelper.PageHelper;
import com.nit.experiment.common.util.WebUtil;
import com.nit.experiment.dao.TaskAcceptMapper;
import com.nit.experiment.dao.TaskMapper;
import com.nit.experiment.dto.MyTaskDTO;
import com.nit.experiment.dto.TaskDTO;
import com.nit.experiment.entity.Task;
import com.nit.experiment.entity.TaskAccept;
import com.nit.experiment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by 江建平 on 2017/9/18.
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TaskAcceptMapper taskAcceptMapper;
    @Override
    public List<MyTaskDTO> searchTasksWithStatus(HttpServletRequest request, Integer state, Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType) {
        PageHelper.startPage(page, pageSize);
        Integer userId = WebUtil.getCurrentUser(request).getUserId();
        return taskMapper.listTaskWithStatus(userId, state, searchKey, orderColumn, orderType);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        Integer currentUserId = WebUtil.getCurrentUser(request).getUserId();
        return taskMapper.listAllTasks(currentUserId);
    }

    @Override
    public int add2MyTasks(TaskAccept accept) {
        accept.setAcceptTime(new Date());
        return taskAcceptMapper.insertSelective(accept);
    }

}
