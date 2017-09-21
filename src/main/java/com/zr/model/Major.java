package com.zr.model;
/**
 * 专业模型
 * @author Administrator
 *
 */
public class Major {
	private int majid; //专业id
	private int colid; //学院id
	private String majname; //专业名称
	public int getMajid() {
		return majid;
	}
	public void setMajid(int majid) {
		this.majid = majid;
	}
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public String getMajname() {
		return majname;
	}
	public void setMajname(String majname) {
		this.majname = majname;
	}
	
}
