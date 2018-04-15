package com.renji.model;

import java.util.Date;

public class EmBedindex {
    private String bedindex;

    private Date createtime;

    public EmBedindex() {
		super();
	}

	public EmBedindex(String bedindex, Date createtime) {
		super();
		this.bedindex = bedindex;
		this.createtime = createtime;
	}

	public String getBedindex() {
        return bedindex;
    }

    public void setBedindex(String bedindex) {
        this.bedindex = bedindex == null ? null : bedindex.trim();
    }

    public Date getcreatetime() {
        return createtime;
    }

    public void setcreatetime(Date createtime) {
        this.createtime = createtime;
    }

	@Override
	public String toString() {
		return "EmBedindex [bedindex=" + bedindex + ", createtime=" + createtime + "]";
	}
}