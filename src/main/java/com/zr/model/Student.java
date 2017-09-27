package com.zr.model;
/**
 * 学生模型
 * @author Administrator
 *
 */
public class Student {
	private int sid; //学生编号
	private int num; //学生学号
	private int colid; //学院ID
	private String colname; //学院名称
	private String majname; //专业名称
	private int majid; //专业id
	private int subid; //选题id
	private String subname; //选题名称
	private String sname; //学生姓名
	private String spsw; //密码
	private int score;//答辩成绩
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getMajname() {
		return majname;
	}
	public void setMajname(String majname) {
		this.majname = majname;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
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
