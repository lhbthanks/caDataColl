package com.classnet.form.suzuki;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class A301Form extends ActionForm {
	private Integer id;
	private String vin;
	private String ab_on;
	private Date datatime;
	private Date time;
	private String bcm;
	private String ipc;
	private String ems;
	private String abs;
	private String tcm; 
	private String srs; 
	private String result;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAb_on() {
		return ab_on;
	}
	public void setAb_on(String ab_on) {
		this.ab_on = ab_on;
	}
	public Date getDatatime() {
		return datatime;
	}
	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getBcm() {
		return bcm;
	}
	public void setBcm(String bcm) {
		this.bcm = bcm;
	}
	public String getIpc() {
		return ipc;
	}
	public void setIpc(String ipc) {
		this.ipc = ipc;
	}
	public String getEms() {
		return ems;
	}
	public void setEms(String ems) {
		this.ems = ems;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getTcm() {
		return tcm;
	}
	public void setTcm(String tcm) {
		this.tcm = tcm;
	}
	public String getSrs() {
		return srs;
	}
	public void setSrs(String srs) {
		this.srs = srs;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	} 

	
}
