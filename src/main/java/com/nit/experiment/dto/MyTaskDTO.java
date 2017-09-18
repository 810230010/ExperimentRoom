package com.nit.experiment.dto;

import com.nit.experiment.common.util.JsonDateUtil;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created by 江建平 on 2017/9/18.
 */

public class MyTaskDTO {
    private Integer taskId;
    private String taskTitle;
    private String description;
    private Date beginTime;
    private Date endTime;
    private Integer isFinished;
    private Date finishedTime;
    private String taskFile;
    private String remark;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer2.class)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer2.class)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer2.class)
    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getTaskFile() {
        return taskFile;
    }

    public void setTaskFile(String taskFile) {
        this.taskFile = taskFile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
