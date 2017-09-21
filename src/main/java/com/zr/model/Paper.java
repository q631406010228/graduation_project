package com.zr.model;
/**
 * 论文模型
 * @author Administrator
 *
 */
public class Paper {
	private int lwid; //论文ID 
	private String lwcontent; //论文内容
	private int sid; //学生id
	private int lwstate; //论文状态
	private int lwcount; //论文提交次数
	public int getLwid() {
		return lwid;
	}
	public void setLwid(int lwid) {
		this.lwid = lwid;
	}
	public String getLwcontent() {
		return lwcontent;
	}
	public void setLwcontent(String lwcontent) {
		this.lwcontent = lwcontent;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getLwstate() {
		return lwstate;
	}
	public void setLwstate(int lwstate) {
		this.lwstate = lwstate;
	}
	public int getLwcount() {
		return lwcount;
	}
	public void setLwcount(int lwcount) {
		this.lwcount = lwcount;
	}
	
}
