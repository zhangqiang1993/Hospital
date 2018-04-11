package com.renji.model;

public class BmBedstatus {
	private String bedindex;

	private String begtime;

    private String endtime;
	
    private String mondiseasename;

    private String monbedstatus;

    private String tuediseasename;

    private String tuebedstatus;

    private String weddiseasename;

    private String wedbedstatus;

    private String thudiseasename;

    private String thubedstatus;

    private String fridiseasename;

    private String fribedstatus;

    private String satdiseasename;

    private String satbedstatus;

    private String sundiseasename;

    private String sunbedstatus;
    
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

    public String getMonbedstatus() {
        return monbedstatus;
    }

    public void setMonbedstatus(String monbedstatus) {
        this.monbedstatus = monbedstatus == null ? null : monbedstatus.trim();
    }

    public String getTuediseasename() {
        return tuediseasename;
    }

    public void setTuediseasename(String tuediseasename) {
        this.tuediseasename = tuediseasename == null ? null : tuediseasename.trim();
    }

    public String getTuebedstatus() {
        return tuebedstatus;
    }

    public void setTuebedstatus(String tuebedstatus) {
        this.tuebedstatus = tuebedstatus == null ? null : tuebedstatus.trim();
    }

    public String getWeddiseasename() {
        return weddiseasename;
    }

    public void setWeddiseasename(String weddiseasename) {
        this.weddiseasename = weddiseasename == null ? null : weddiseasename.trim();
    }

    public String getWedbedstatus() {
        return wedbedstatus;
    }

    public void setWedbedstatus(String wedbedstatus) {
        this.wedbedstatus = wedbedstatus == null ? null : wedbedstatus.trim();
    }

    public String getThudiseasename() {
        return thudiseasename;
    }

    public void setThudiseasename(String thudiseasename) {
        this.thudiseasename = thudiseasename == null ? null : thudiseasename.trim();
    }

    public String getThubedstatus() {
        return thubedstatus;
    }

    public void setThubedstatus(String thubedstatus) {
        this.thubedstatus = thubedstatus == null ? null : thubedstatus.trim();
    }

    public String getFridiseasename() {
        return fridiseasename;
    }

    public void setFridiseasename(String fridiseasename) {
        this.fridiseasename = fridiseasename == null ? null : fridiseasename.trim();
    }

    public String getFribedstatus() {
        return fribedstatus;
    }

    public void setFribedstatus(String fribedstatus) {
        this.fribedstatus = fribedstatus == null ? null : fribedstatus.trim();
    }

    public String getSatdiseasename() {
        return satdiseasename;
    }

    public void setSatdiseasename(String satdiseasename) {
        this.satdiseasename = satdiseasename == null ? null : satdiseasename.trim();
    }

    public String getSatbedstatus() {
        return satbedstatus;
    }

    public void setSatbedstatus(String satbedstatus) {
        this.satbedstatus = satbedstatus == null ? null : satbedstatus.trim();
    }

    public String getSundiseasename() {
        return sundiseasename;
    }

    public void setSundiseasename(String sundiseasename) {
        this.sundiseasename = sundiseasename == null ? null : sundiseasename.trim();
    }

    public String getSunbedstatus() {
        return sunbedstatus;
    }

    public void setSunbedstatus(String sunbedstatus) {
        this.sunbedstatus = sunbedstatus == null ? null : sunbedstatus.trim();
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