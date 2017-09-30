package com.zr.model;
/**
 * 论文模型
 * @author Administrator
 *
 */
public class Paper {
	private int lwid; //论文ID 
	private String lwname; //论文名称
	private int sid; //学生id
	private int snum;//学生学号
	private String sname;//学生姓名
	private String lwstate; //论文状态
	private int lwcount; //论文提交次数
	private String lwoperate;//论文状态
	private String lwbackload;
	public String getLwbackload() {
		return lwbackload;
	}
	public void setLwbackload(String lwbackload) {
		this.lwbackload = lwbackload;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getLwid() {
		return lwid;
	}
	public void setLwid(int lwid) {
		this.lwid = lwid;
	}
	public String getLwname() {
		return lwname;
	}
	public void setLwname(String lwname) {
		this.lwname = lwname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getLwstate() {
		return lwstate;
	}
	public void setLwstate(String lwstate) {
		this.lwstate = lwstate;
	}
	public String getLwoperate() {
		return lwoperate;
	}
	public void setLwoperate(String lwoperate) {
		this.lwoperate = lwoperate;
	}
	public int getLwcount() {
		return lwcount;
	}
	public void setLwcount(int lwcount) {
		this.lwcount = lwcount;
	}
	
}
