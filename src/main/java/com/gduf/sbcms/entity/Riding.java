package com.gduf.sbcms.entity;

import java.util.Date;

public class Riding {
    private Integer id;

    private String ridingStatus;

    private Integer userId;

    private Date starttime;

    private Double length;

    private Date endtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRidingStatus() {
        return ridingStatus;
    }

    public void setRidingStatus(String ridingStatus) {
        this.ridingStatus = ridingStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}