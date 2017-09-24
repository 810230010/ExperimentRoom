package com.nit.experiment.dto;

import com.nit.experiment.common.util.JsonDateUtil;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created by usher on 2017/9/24.
 */
public class MyQuestionDTO {
    private Integer questionId;
    private String title;
    private String category;
    private Integer viewNo;
    private Integer thumbupNo;
    private Integer answerNo;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
