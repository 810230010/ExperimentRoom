package com.nit.experiment.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by 江建平 on 2017/9/19.
 */
@Data
public class TaskDTO {
    private Integer taskId;

    private String userName;

    private String taskTitle;

    private Integer userId;

    private String description;

    private Integer acceptTaskId;

}
