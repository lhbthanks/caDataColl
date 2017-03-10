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
@Table(name="T_COOLANT_YH")
public class CoolantYhEntity implements Serializable{
	private Integer id;
	private String vin_code;
	private String car_type;
	private String mobile_unit;
	private String filling_result;
	private Date data_time;
	private String corse_vacuum;
	private String corse_vacuum_time;
	private String fine_vacuum;
	private String fine_vacuum_time;
	private String vacuum_leak;
	private String vacuum_leak_time;
	private String post_vacuum;
	private String post_vacuum_time;
	private String filling_pressure;
	private String filling_volume;
	private String filling_volume_time;
	private String process_cycle_time;
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private String col6;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="vin_code")
	public String getVin_code() {
		return vin_code;
	}
	public void setVin_code(String vin_code) {
		this.vin_code = vin_code;
	}
	@Column(name="car_type")
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	@Column(name="mobile_unit")
	public String getMobile_unit() {
		return mobile_unit;
	}
	public void setMobile_unit(String mobile_unit) {
		this.mobile_unit = mobile_unit;
	}
	@Column(name="filling_result")
	public String getFilling_result() {
		return filling_result;
	}
	public void setFilling_result(String filling_result) {
		this.filling_result = filling_result;
	}
	@Column(name="data_time")
	public Date getData_time() {
		return data_time;
	}
	public void setData_time(Date data_time) {
		this.data_time = data_time;
	}
	@Column(name="corse_vacuum")
	public String getCorse_vacuum() {
		return corse_vacuum;
	}
	public void setCorse_vacuum(String corse_vacuum) {
		this.corse_vacuum = corse_vacuum;
	}
	@Column(name="corse_vacuum_time")
	public String getCorse_vacuum_time() {
		return corse_vacuum_time;
	}
	public void setCorse_vacuum_time(String corse_vacuum_time) {
		this.corse_vacuum_time = corse_vacuum_time;
	}
	@Column(name="fine_vacuum")
	public String getFine_vacuum() {
		return fine_vacuum;
	}
	public void setFine_vacuum(String fine_vacuum) {
		this.fine_vacuum = fine_vacuum;
	}
	@Column(name="fine_vacuum_time")
	public String getFine_vacuum_time() {
		return fine_vacuum_time;
	}
	public void setFine_vacuum_time(String fine_vacuum_time) {
		this.fine_vacuum_time = fine_vacuum_time;
	}
	@Column(name="vacuum_leak")
	public String getVacuum_leak() {
		return vacuum_leak;
	}
	public void setVacuum_leak(String vacuum_leak) {
		this.vacuum_leak = vacuum_leak;
	}
	@Column(name="vacuum_leak_time")
	public String getVacuum_leak_time() {
		return vacuum_leak_time;
	}
	public void setVacuum_leak_time(String vacuum_leak_time) {
		this.vacuum_leak_time = vacuum_leak_time;
	}
	@Column(name="post_vacuum")
	public String getPost_vacuum() {
		return post_vacuum;
	}
	public void setPost_vacuum(String post_vacuum) {
		this.post_vacuum = post_vacuum;
	}
	@Column(name="post_vacuum_time")
	public String getPost_vacuum_time() {
		return post_vacuum_time;
	}
	public void setPost_vacuum_time(String post_vacuum_time) {
		this.post_vacuum_time = post_vacuum_time;
	}
	@Column(name="filling_pressure")
	public String getFilling_pressure() {
		return filling_pressure;
	}
	public void setFilling_pressure(String filling_pressure) {
		this.filling_pressure = filling_pressure;
	}
	@Column(name="filling_volume")
	public String getFilling_volume() {
		return filling_volume;
	}
	public void setFilling_volume(String filling_volume) {
		this.filling_volume = filling_volume;
	}
	@Column(name="filling_volume_time")
	public String getFilling_volume_time() {
		return filling_volume_time;
	}
	public void setFilling_volume_time(String filling_volume_time) {
		this.filling_volume_time = filling_volume_time;
	}
	@Column(name="process_cycle_time")
	public String getProcess_cycle_time() {
		return process_cycle_time;
	}
	public void setProcess_cycle_time(String process_cycle_time) {
		this.process_cycle_time = process_cycle_time;
	}
	@Column(name="col1")
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	@Column(name="col2")
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	@Column(name="col3")
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	@Column(name="col4")
	public String getCol4() {
		return col4;
	}
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	@Column(name="col5")
	public String getCol5() {
		return col5;
	}
	public void setCol5(String col5) {
		this.col5 = col5;
	}
	@Column(name="col6")
	public String getCol6() {
		return col6;
	}
	public void setCol6(String col6) {
		this.col6 = col6;
	}
	
	

}
