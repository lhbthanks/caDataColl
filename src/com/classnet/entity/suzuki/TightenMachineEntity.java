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
@Table(name="T_TIGHTEN_MACHINE")
public class TightenMachineEntity implements Serializable{
	private Integer id;
	private String identifier;
	private String node;
	private String tooltype;
	private String result;
	private Date daterq;
	private String time;
	private Integer channel;
	private Integer program;
	private Integer cycle;
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
	private String data11;
	private String data12;
	private String data13;
	private String duop;
	private String op;
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
	@Column(name="identifier")
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Column(name="node")
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	@Column(name="tooltype")
	public String getTooltype() {
		return tooltype;
	}
	public void setTooltype(String tooltype) {
		this.tooltype = tooltype;
	}
	@Column(name="result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="daterq")
	public Date getDaterq() {
		return daterq;
	}
	public void setDaterq(Date daterq) {
		this.daterq = daterq;
	}
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(name="channel")
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	@Column(name="program")
	public Integer getProgram() {
		return program;
	}
	public void setProgram(Integer program) {
		this.program = program;
	}
	@Column(name="cycle")
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
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
	@Column(name="data11")
	public String getData11() {
		return data11;
	}
	public void setData11(String data11) {
		this.data11 = data11;
	}
	@Column(name="data12")
	public String getData12() {
		return data12;
	}
	public void setData12(String data12) {
		this.data12 = data12;
	}
	@Column(name="data13")
	public String getData13() {
		return data13;
	}
	public void setData13(String data13) {
		this.data13 = data13;
	}
	@Column(name="duop")
	public String getDuop() {
		return duop;
	}
	public void setDuop(String duop) {
		this.duop = duop;
	}
	@Column(name="op")
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
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
