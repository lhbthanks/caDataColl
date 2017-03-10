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
@Table(name="t_AIRTIGHT_CHECK")
public class AirtightCheckEntity implements Serializable{
	private String airtightid;
	private String r_abon;
	private String r_vin;
	private String r_type;
	private Date  r_date;
	private Date  r_time;
	private String r_qmtp;
	private String r_qmtd;
	private String r_qmdr;
	private String r_tqtp;
	private String r_tqtd;
	private String r_tqdr;
	private String r_power;
	
	@Id
	@GeneratedValue
	public String getAirtightid() {
		return airtightid;
	}
	public void setAirtightid(String airtightid) {
		this.airtightid = airtightid;
	}
	@Column(name="r_abon")
	public String getR_abon() {
		return r_abon;
	}
	public void setR_abon(String r_abon) {
		this.r_abon = r_abon;
	}
	@Column(name="r_vin")
	public String getR_vin() {
		return r_vin;
	}
	public void setR_vin(String r_vin) {
		this.r_vin = r_vin;
	}
	@Column(name="r_type")
	public String getR_type() {
		return r_type;
	}
	public void setR_type(String r_type) {
		this.r_type = r_type;
	}
	@Column(name="r_date")
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	@Column(name="r_time")
	public Date getR_time() {
		return r_time;
	}
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
	@Column(name="r_qmtp")
	public String getR_qmtp() {
		return r_qmtp;
	}
	public void setR_qmtp(String r_qmtp) {
		this.r_qmtp = r_qmtp;
	}
	@Column(name="r_qmtd")
	public String getR_qmtd() {
		return r_qmtd;
	}
	public void setR_qmtd(String r_qmtd) {
		this.r_qmtd = r_qmtd;
	}
	@Column(name="r_qmdr")
	public String getR_qmdr() {
		return r_qmdr;
	}
	public void setR_qmdr(String r_qmdr) {
		this.r_qmdr = r_qmdr;
	}
	@Column(name="r_tqtp")
	public String getR_tqtp() {
		return r_tqtp;
	}
	public void setR_tqtp(String r_tqtp) {
		this.r_tqtp = r_tqtp;
	}
	@Column(name="r_tqtd")
	public String getR_tqtd() {
		return r_tqtd;
	}
	public void setR_tqtd(String r_tqtd) {
		this.r_tqtd = r_tqtd;
	}
	@Column(name="r_tqdr")
	public String getR_tqdr() {
		return r_tqdr;
	}
	public void setR_tqdr(String r_tqdr) {
		this.r_tqdr = r_tqdr;
	}
	@Column(name="r_power")
	public String getR_power() {
		return r_power;
	}
	public void setR_power(String r_power) {
		this.r_power = r_power;
	}
}
