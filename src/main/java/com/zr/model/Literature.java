package com.zr.model;

public class Literature {
	private int wxid; //文献ID 
	private String wxcontent; //文献内容（存路径）
	private int wxstate; //文献状态
	private int wxlx; //文献类型
	private int sid; //学生id
	public int getWxid() {
		return wxid;
	}
	public void setWxid(int wxid) {
		this.wxid = wxid;
	}
	public String getWxcontent() {
		return wxcontent;
	}
	public void setWxcontent(String wxcontent) {
		this.wxcontent = wxcontent;
	}
	public int getWxstate() {
		return wxstate;
	}
	public void setWxstate(int wxstate) {
		this.wxstate = wxstate;
	}
	public int getWxlx() {
		return wxlx;
	}
	public void setWxlx(int wxlx) {
		this.wxlx = wxlx;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
