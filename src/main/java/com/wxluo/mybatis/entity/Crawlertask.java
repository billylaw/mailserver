package com.wxluo.mybatis.entity;

import java.io.Serializable;

public class Crawlertask implements Serializable {
    private Integer crawlerID;

    private Integer groupID;

    private Integer userID;

    private String keywords;

    private String searchArea;

    private String searchDate;

    private String timer;

    private Byte type;

    private Long doneTime;

    private Long createTime;

    private Long updateTime;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getCrawlerID() {
        return crawlerID;
    }

    public void setCrawlerID(Integer crawlerID) {
        this.crawlerID = crawlerID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getSearchArea() {
        return searchArea;
    }

    public void setSearchArea(String searchArea) {
        this.searchArea = searchArea == null ? null : searchArea.trim();
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate == null ? null : searchDate.trim();
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer == null ? null : timer.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Long doneTime) {
        this.doneTime = doneTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", crawlerID=").append(crawlerID);
        sb.append(", groupID=").append(groupID);
        sb.append(", userID=").append(userID);
        sb.append(", keywords=").append(keywords);
        sb.append(", searchArea=").append(searchArea);
        sb.append(", searchDate=").append(searchDate);
        sb.append(", timer=").append(timer);
        sb.append(", type=").append(type);
        sb.append(", doneTime=").append(doneTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}