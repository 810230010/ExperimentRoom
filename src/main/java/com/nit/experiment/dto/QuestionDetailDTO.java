package com.nit.experiment.dto;

import com.nit.experiment.common.util.JsonDateUtil;
import com.nit.experiment.entity.Answer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/30.
 */
public class QuestionDetailDTO {
    private Integer questionId;
    private String title;
    private String content;
    private String category;
    private String userName;
    private Date createTime;
    private List<AnswerDTO> answer;

    public List<AnswerDTO> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerDTO> answer) {
        this.answer = answer;
    }

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
    @JsonSerialize(using=JsonDateUtil.JsonDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
