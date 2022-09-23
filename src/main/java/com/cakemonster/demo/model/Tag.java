package com.cakemonster.demo.model;

import java.util.Date;

/**
 * Tag
 *
 * @author Zqh
 * @date 2020/4/15
 */
public class Tag {

    /**
     * id
     */
    private String id;

    /**
     * 所属问题id
     */
    private String questionId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 更新时间
     */
    private Date gmtModified;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id='" + id + '\'' +
            ", questionId='" + questionId + '\'' +
            ", tagName='" + tagName + '\'' +
            ", gmtCreated=" + gmtCreated +
            ", gmtModified=" + gmtModified +
            '}';
    }
}
