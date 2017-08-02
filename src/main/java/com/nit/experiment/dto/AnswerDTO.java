package com.nit.experiment.dto;

import com.nit.experiment.common.util.JsonDateUtil;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by 江建平 on 2017/8/1.
 */
public class AnswerDTO {
    private Integer answerId;
    private Integer parentId;
    private Integer questionId;
    private String answerer;
    private String answerContent;
    private Boolean isAccept;
    private Date answerTime;
    private List<AnswerDTO> answerReply;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswerer() {
        return answerer;
    }

    public void setAnswerer(String answerer) {
        this.answerer = answerer;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Boolean getAccept() {
        return isAccept;
    }

    public void setAccept(Boolean accept) {
        isAccept = accept;
    }
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer.class)
    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public List<AnswerDTO> getAnswerReply() {
        return answerReply;
    }

    public void setAnswerReply(List<AnswerDTO> answerReply) {
        this.answerReply = answerReply;
    }
}
