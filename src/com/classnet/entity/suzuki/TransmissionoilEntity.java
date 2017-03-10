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
@Table(name="T_TRANSMISSIONOIL")
public class TransmissionoilEntity implements Serializable{
	private Integer recordid;
	private Date datetime;
	private Integer abon;
	private String vin;
	private String carmodelcode;
	private Integer fcid;
	private Integer productionline;
	private Integer station;
	private String data1;
	private String data2;
	private String data3;
	private String data4;
	private String data5;
	private String data6;
	private String data7;
	private String data8;
	private String data9;
	private String data10;
	private String eventtype;
	
	@Id
	@GeneratedValue
	public Integer getRecordid() {
		return recordid;
	}
	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
	}
	@Column(name="datetime")
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Column(name="abon")
	public Integer getAbon() {
		return abon;
	}
	public void setAbon(Integer abon) {
		this.abon = abon;
	}
	@Column(name="vin")
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	@Column(name="carmodelcode")
	public String getCarmodelcode() {
		return carmodelcode;
	}
	public void setCarmodelcode(String carmodelcode) {
		this.carmodelcode = carmodelcode;
	}
	@Column(name="fcid")
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	@Column(name="productionline")
	public Integer getProductionline() {
		return productionline;
	}
	public void setProductionline(Integer productionline) {
		this.productionline = productionline;
	}
	@Column(name="station")
	public Integer getStation() {
		return station;
	}
	public void setStation(Integer station) {
		this.station = station;
	}
	@Column(name="data1")
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	@Column(name="data2")
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	@Column(name="data3")
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}
	@Column(name="data4")
	public String getData4() {
		return data4;
	}
	public void setData4(String data4) {
		this.data4 = data4;
	}
	@Column(name="data5")
	public String getData5() {
		return data5;
	}
	public void setData5(String data5) {
		this.data5 = data5;
	}
	@Column(name="data6")
	public String getData6() {
		return data6;
	}
	public void setData6(String data6) {
		this.data6 = data6;
	}
	@Column(name="data7")
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	@Column(name="data8")
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}
	@Column(name="data9")
	public String getData9() {
		return data9;
	}
	public void setData9(String data9) {
		this.data9 = data9;
	}
	@Column(name="data10")
	public String getData10() {
		return data10;
	}
	public void setData10(String data10) {
		this.data10 = data10;
	}
	@Column(name="eventtype")
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
}
