package com.nit.experiment.entity;

import java.util.Date;

public class Task {
    private Integer taskId;

    private String taskTitle;

    private Integer userId;

    private String description;

    private Boolean isAdminCreate;

    private Date createTime;

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
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getIsAdminCreate() {
        return isAdminCreate;
    }

    public void setIsAdminCreate(Boolean isAdminCreate) {
        this.isAdminCreate = isAdminCreate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}