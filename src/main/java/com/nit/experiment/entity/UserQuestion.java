package com.nit.experiment.entity;

public class UserQuestion {
    private Integer userQuestionId;

    private Integer questionId;

    private Integer userId;

    private Boolean isThumbup;

    private Boolean isCollected;

    private Boolean isCommented;

    public Integer getUserQuestionId() {
        return userQuestionId;
    }

    public void setUserQuestionId(Integer userQuestionId) {
        this.userQuestionId = userQuestionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsThumbup() {
        return isThumbup;
    }

    public void setIsThumbup(Boolean isThumbup) {
        this.isThumbup = isThumbup;
    }

    public Boolean getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Boolean isCollected) {
        this.isCollected = isCollected;
    }

    public Boolean getIsCommented() {
        return isCommented;
    }

    public void setIsCommented(Boolean isCommented) {
        this.isCommented = isCommented;
    }
}