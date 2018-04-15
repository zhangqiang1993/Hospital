package com.renji.model;

public class BmBedstatus {
	private String bedindex;

	private String begtime;

    private String endtime;
	
    private String mondiseasename;

    private int monbedstatus;

    private String tuediseasename;

    private int tuebedstatus;

    private String weddiseasename;

    private int wedbedstatus;

    private String thudiseasename;

    private int thubedstatus;

    private String fridiseasename;

    private int fribedstatus;

    private String satdiseasename;

    private int satbedstatus;

    private String sundiseasename;

    private int sunbedstatus;
    
    public BmBedstatus(){
    	super();
    }
    
    public BmBedstatus(String bedindex, String begtime, String endtime){
    	this.bedindex = bedindex;
    	this.begtime = begtime;
    	this.endtime = endtime;
    }
    
    public String getBedindex() {
        return bedindex;
    }

    public void setBedindex(String bedindex) {
        this.bedindex = bedindex == null ? null : bedindex.trim();
    }

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

    public String getMondiseasename() {
        return mondiseasename;
    }

    public void setMondiseasename(String mondiseasename) {
        this.mondiseasename = mondiseasename == null ? null : mondiseasename.trim();
    }

    public int getMonbedstatus() {
        return monbedstatus;
    }

    public void setMonbedstatus(int monbedstatus) {
        this.monbedstatus = monbedstatus;
    }

    public String getTuediseasename() {
        return tuediseasename;
    }

    public void setTuediseasename(String tuediseasename) {
        this.tuediseasename = tuediseasename;
    }

    public int getTuebedstatus() {
        return tuebedstatus;
    }

    public void setTuebedstatus(int tuebedstatus) {
        this.tuebedstatus = tuebedstatus;
    }

    public String getWeddiseasename() {
        return weddiseasename;
    }

    public void setWeddiseasename(String weddiseasename) {
        this.weddiseasename = weddiseasename == null ? null : weddiseasename.trim();
    }

    public int getWedbedstatus() {
        return wedbedstatus;
    }

    public void setWedbedstatus(int wedbedstatus) {
        this.wedbedstatus = wedbedstatus;
    }

    public String getThudiseasename() {
        return thudiseasename;
    }

    public void setThudiseasename(String thudiseasename) {
        this.thudiseasename = thudiseasename == null ? null : thudiseasename.trim();
    }

    public int getThubedstatus() {
        return thubedstatus;
    }

    public void setThubedstatus(int thubedstatus) {
        this.thubedstatus = thubedstatus;
    }

    public String getFridiseasename() {
        return fridiseasename;
    }

    public void setFridiseasename(String fridiseasename) {
        this.fridiseasename = fridiseasename == null ? null : fridiseasename.trim();
    }

    public int getFribedstatus() {
        return fribedstatus;
    }

    public void setFribedstatus(int fribedstatus) {
        this.fribedstatus = fribedstatus;
    }

    public String getSatdiseasename() {
        return satdiseasename;
    }

    public void setSatdiseasename(String satdiseasename) {
        this.satdiseasename = satdiseasename == null ? null : satdiseasename.trim();
    }

    public int getSatbedstatus() {
        return satbedstatus;
    }

    public void setSatbedstatus(int satbedstatus) {
        this.satbedstatus = satbedstatus;
    }

    public String getSundiseasename() {
        return sundiseasename;
    }

    public void setSundiseasename(String sundiseasename) {
        this.sundiseasename = sundiseasename == null ? null : sundiseasename.trim();
    }

    public int getSunbedstatus() {
        return sunbedstatus;
    }

    public void setSunbedstatus(int sunbedstatus) {
        this.sunbedstatus = sunbedstatus;
    }

	@Override
	public String toString() {
		return "BmBedstatus [bedindex=" + bedindex + ", begtime=" + begtime + ", endtime=" + endtime
				+ ", mondiseasename=" + mondiseasename + ", monbedstatus=" + monbedstatus + ", tuediseasename="
				+ tuediseasename + ", tuebedstatus=" + tuebedstatus + ", weddiseasename=" + weddiseasename
				+ ", wedbedstatus=" + wedbedstatus + ", thudiseasename=" + thudiseasename + ", thubedstatus="
				+ thubedstatus + ", fridiseasename=" + fridiseasename + ", fribedstatus=" + fribedstatus
				+ ", satdiseasename=" + satdiseasename + ", satbedstatus=" + satbedstatus + ", sundiseasename="
				+ sundiseasename + ", sunbedstatus=" + sunbedstatus + "]";
	}
}