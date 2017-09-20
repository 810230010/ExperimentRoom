package com.nit.experiment.dao;

import com.nit.experiment.common.dao.BaseMapper;
import com.nit.experiment.dto.MyTaskDTO;
import com.nit.experiment.dto.TaskDTO;
import com.nit.experiment.entity.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 江建平 on 2017/9/18.
 */
public interface TaskMapper extends BaseMapper<Task, Integer>{
    /**
     * 根据状态查询我的任务
     * @param state 0:未完成 1:已完成 2:正在进行中
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @return
     */
    List<MyTaskDTO> listTaskWithStatus(@Param("userId") Integer userId,@Param("state") Integer state, @Param("searchKey") String searchKey, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

    /**
     * 查询所有任务
     * @return
     */
    List<TaskDTO> listAllTasks(@Param("userId") Integer userId);
}
