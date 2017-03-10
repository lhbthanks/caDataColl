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
@Table(name="T_DETACHMENT")
public class DetachmentEntity implements Serializable{
	private String detachmentid;
	private String t_abon;
	private String t_vin;
	private String t_type;
	private Date t_date;
	private Date t_time;
	private String t_result;
	private String t_tp;
	private String t_fl;
	private String t_800p;
	private String t_800fl;
	private String t_1000p;
	private String t_1000fl;
	private String t_1500p;
	private String t_1500fl;
	private String t_2000p;
	private String t_2000fl;
	private String t_2500p;
	private String t_2500fl;
	private String t_3000p;
	private String t_3000fl;
	private String t_4000p;
	private String t_4000fl;
	private String t_power;
	@Id
	@GeneratedValue
	public String getDetachmentid() {
		return detachmentid;
	}
	public void setDetachmentid(String detachmentid) {
		this.detachmentid = detachmentid;
	}
	@Column(name="t_abon")
	public String getT_abon() {
		return t_abon;
	}
	public void setT_abon(String t_abon) {
		this.t_abon = t_abon;
	}
	@Column(name="t_vin")
	public String getT_vin() {
		return t_vin;
	}
	public void setT_vin(String t_vin) {
		this.t_vin = t_vin;
	}
	@Column(name="t_type")
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	@Column(name="t_date")
	public Date getT_date() {
		return t_date;
	}
	
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	@Column(name="t_time")
	public Date getT_time() {
		return t_time;
	}
	public void setT_time(Date t_time) {
		this.t_time = t_time;
	}
	@Column(name="t_result")
	public String getT_result() {
		return t_result;
	}
	public void setT_result(String t_result) {
		this.t_result = t_result;
	}
	@Column(name="t_tp")
	public String getT_tp() {
		return t_tp;
	}
	public void setT_tp(String t_tp) {
		this.t_tp = t_tp;
	}
	@Column(name="t_fl")
	public String getT_fl() {
		return t_fl;
	}
	public void setT_fl(String t_fl) {
		this.t_fl = t_fl;
	}
	@Column(name="t_800p")
	public String getT_800p() {
		return t_800p;
	}
	public void setT_800p(String t_800p) {
		this.t_800p = t_800p;
	}
	@Column(name="t_800fl")
	public String getT_800fl() {
		return t_800fl;
	}
	public void setT_800fl(String t_800fl) {
		this.t_800fl = t_800fl;
	}
	@Column(name="t_1000p")
	public String getT_1000p() {
		return t_1000p;
	}
	public void setT_1000p(String t_1000p) {
		this.t_1000p = t_1000p;
	}
	@Column(name="t_1000fl")
	public String getT_1000fl() {
		return t_1000fl;
	}
	public void setT_1000fl(String t_1000fl) {
		this.t_1000fl = t_1000fl;
	}
	@Column(name="t_1500p")
	public String getT_1500p() {
		return t_1500p;
	}
	public void setT_1500p(String t_1500p) {
		this.t_1500p = t_1500p;
	}
	@Column(name="t_1500fl")
	public String getT_1500fl() {
		return t_1500fl;
	}
	public void setT_1500fl(String t_1500fl) {
		this.t_1500fl = t_1500fl;
	}
	@Column(name="t_2000p")
	public String getT_2000p() {
		return t_2000p;
	}
	public void setT_2000p(String t_2000p) {
		this.t_2000p = t_2000p;
	}
	@Column(name="t_2000fl")
	public String getT_2000fl() {
		return t_2000fl;
	}
	public void setT_2000fl(String t_2000fl) {
		this.t_2000fl = t_2000fl;
	}
	@Column(name="t_2500p")
	public String getT_2500p() {
		return t_2500p;
	}
	public void setT_2500p(String t_2500p) {
		this.t_2500p = t_2500p;
	}
	@Column(name="t_2500fl")
	public String getT_2500fl() {
		return t_2500fl;
	}
	public void setT_2500fl(String t_2500fl) {
		this.t_2500fl = t_2500fl;
	}
	@Column(name="t_3000p")
	public String getT_3000p() {
		return t_3000p;
	}
	public void setT_3000p(String t_3000p) {
		this.t_3000p = t_3000p;
	}
	@Column(name="t_3000fl")
	public String getT_3000fl() {
		return t_3000fl;
	}
	public void setT_3000fl(String t_3000fl) {
		this.t_3000fl = t_3000fl;
	}
	@Column(name="t_4000p")
	public String getT_4000p() {
		return t_4000p;
	}
	public void setT_4000p(String t_4000p) {
		this.t_4000p = t_4000p;
	}
	@Column(name="t_4000fl")
	public String getT_4000fl() {
		return t_4000fl;
	}
	public void setT_4000fl(String t_4000fl) {
		this.t_4000fl = t_4000fl;
	}
	@Column(name="t_power")
	public String getT_power() {
		return t_power;
	}
	public void setT_power(String t_power) {
		this.t_power = t_power;
	}
	
}
