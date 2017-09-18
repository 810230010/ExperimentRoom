package com.nit.experiment.service;

import com.nit.experiment.dto.MyTaskDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 江建平 on 2017/9/18.
 */
public interface TaskService {

    List<MyTaskDTO> searchTasksWithStatus(HttpServletRequest request, Integer state, Integer page, Integer pageSize, String searchKey, String orderColumn, String orderType);
}
