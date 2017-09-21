package com.zr.model;

public class Student {
	private int sid; //学生编号
	private int num; //学生学号
	private int colid; //学院ID	
	private int majid; //专业id
	private int subid; //选题id
	private String sname; //学生姓名
	private String spsw; //密码
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public int getMajid() {
		return majid;
	}
	public void setMajid(int majid) {
		this.majid = majid;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpsw() {
		return spsw;
	}
	public void setSpsw(String spsw) {
		this.spsw = spsw;
	}
	
}
