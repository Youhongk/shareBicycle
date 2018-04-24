package com.gduf.sbcms.entity;

import java.util.Date;

public class Transactions {
    private Integer tid;

    private Integer uid;

    private Integer number;

    private Date tdate;

    private String type;

    public Transactions(){
    	super();
    }
    
    public Transactions(Integer tid, Integer uid, Integer number, Date tdate, String type) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.number = number;
		this.tdate = tdate;
		this.type = type;
	}

    public Transactions(Integer uid, Integer number, Date tdate, String type) {
		super();
		
		this.uid = uid;
		this.number = number;
		this.tdate = tdate;
		this.type = type;
	}

    public Transactions(Integer number) {
		super();
		this.number = number;
		
	}

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}