package com.nit.experiment.dto;

import com.nit.experiment.common.util.JsonDateUtil;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created by 江建平 on 2017/7/28.
 */
public class QuestionListDTO {
    private Integer questionId;
    private String title;
    private String content;
    private String category;
    private String userName;
    private Integer viewNo;
    private Integer thumbupNo;
    private Integer answerNo;
    private Integer isCollected;
    private Integer isThumbup;

    public Integer getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Integer isCollected) {
        this.isCollected = isCollected;
    }

    public Integer getIsThumbup() {
        return isThumbup;
    }

    public void setIsThumbup(Integer isThumbup) {
        this.isThumbup = isThumbup;
    }

    private Date createTime;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getViewNo() {
        return viewNo;
    }

    public void setViewNo(Integer viewNo) {
        this.viewNo = viewNo;
    }

    public Integer getThumbupNo() {
        return thumbupNo;
    }

    public void setThumbupNo(Integer thumbupNo) {
        this.thumbupNo = thumbupNo;
    }

    public Integer getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(Integer answerNo) {
        this.answerNo = answerNo;
    }
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
