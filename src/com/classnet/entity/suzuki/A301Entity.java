package com.classnet.entity.suzuki;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="T_A301")
public class A301Entity implements Serializable{
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
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="vin")
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	@Column(name="ab_on")
	public String getAb_on() {
		return ab_on;
	}
	public void setAb_on(String ab_on) {
		this.ab_on = ab_on;
	}
	@Column(name="datatime")
	public Date getDatatime() {
		return datatime;
	}
	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Column(name="bcm")
	public String getBcm() {
		return bcm;
	}
	public void setBcm(String bcm) {
		this.bcm = bcm;
	}
	@Column(name="ipc")
	public String getIpc() {
		return ipc;
	}
	public void setIpc(String ipc) {
		this.ipc = ipc;
	}
	@Column(name="ems")
	public String getEms() {
		return ems;
	}
	public void setEms(String ems) {
		this.ems = ems;
	}
	@Column(name="abs")
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	@Column(name="tcm")
	public String getTcm() {
		return tcm;
	}
	public void setTcm(String tcm) {
		this.tcm = tcm;
	}
	@Column(name="srs")
	public String getSrs() {
		return srs;
	}
	public void setSrs(String srs) {
		this.srs = srs;
	}
	@Column(name="result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	} 
}
