package com.nit.experiment.entity;

import java.util.Date;

public class AnswerReply {
    private Integer answerReplyId;

    private String replyContent;

    private Date replyTime;

    private Integer userId;

    public Integer getAnswerReplyId() {
        return answerReplyId;
    }

    public void setAnswerReplyId(Integer answerReplyId) {
        this.answerReplyId = answerReplyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}