package com.zy.crm.entity;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable{

    private Integer logsId;
    private Date date;
    private String remark;
    private User user;

    public Integer getLogsId() {
        return logsId;
    }

    public void setLogsId(Integer logsId) {
        this.logsId = logsId;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
