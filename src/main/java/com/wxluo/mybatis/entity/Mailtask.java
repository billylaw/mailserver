package com.wxluo.mybatis.entity;

import java.io.Serializable;

public class Mailtask implements Serializable {
    private Integer mailID;

    private Integer groupID;

    private Integer userID;

    private String keywords;

    private String searchArea;

    private String searchDate;

    private String timer;

    private Byte type;

    private String sendMails;

    private Integer sendNums;

    private Integer arriveNums;

    private Integer denyNums;

    private Long createTime;

    private Long updateTime;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getMailID() {
        return mailID;
    }

    public void setMailID(Integer mailID) {
        this.mailID = mailID;
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

    public String getSendMails() {
        return sendMails;
    }

    public void setSendMails(String sendMails) {
        this.sendMails = sendMails == null ? null : sendMails.trim();
    }

    public Integer getSendNums() {
        return sendNums;
    }

    public void setSendNums(Integer sendNums) {
        this.sendNums = sendNums;
    }

    public Integer getArriveNums() {
        return arriveNums;
    }

    public void setArriveNums(Integer arriveNums) {
        this.arriveNums = arriveNums;
    }

    public Integer getDenyNums() {
        return denyNums;
    }

    public void setDenyNums(Integer denyNums) {
        this.denyNums = denyNums;
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
        sb.append(", mailID=").append(mailID);
        sb.append(", groupID=").append(groupID);
        sb.append(", userID=").append(userID);
        sb.append(", keywords=").append(keywords);
        sb.append(", searchArea=").append(searchArea);
        sb.append(", searchDate=").append(searchDate);
        sb.append(", timer=").append(timer);
        sb.append(", type=").append(type);
        sb.append(", sendMails=").append(sendMails);
        sb.append(", sendNums=").append(sendNums);
        sb.append(", arriveNums=").append(arriveNums);
        sb.append(", denyNums=").append(denyNums);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}