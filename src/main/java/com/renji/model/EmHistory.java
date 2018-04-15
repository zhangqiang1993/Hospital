package com.renji.model;

public class EmHistory {
    private String begtime;

    private String endtime;

    public String getBegtime() {
        return begtime;
    }

    public void setBegtime(String begtime) {
        this.begtime = begtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

	@Override
	public String toString() {
		return "EmHistory [begtime=" + begtime + ", endtime=" + endtime + "]";
	}
}