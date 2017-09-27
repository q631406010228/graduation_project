package com.zr.model;

public class Literature {
	private int wxid; //文献ID 
	private String wxcontent; //文献内容（存路径）
	private String wxstate; //文献状态
	private int wxlxid; //文献类型
	private int sid; //学生id
	private String wxlxname;//文献类型名
	private String sname;//学生名称
	private String wxname;//文献名称
	public String getWxname() {
		return wxname;
	}
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	public int getWxlxid() {
		return wxlxid;
	}
	public void setWxlxid(int wxlxid) {
		this.wxlxid = wxlxid;
	}
	public String getWxlxname() {
		return wxlxname;
	}
	public void setWxlxname(String wxlxname) {
		this.wxlxname = wxlxname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
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
	public String getWxstate() {
		return wxstate;
	}
	public void setWxstate(String wxstate) {
		this.wxstate = wxstate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
