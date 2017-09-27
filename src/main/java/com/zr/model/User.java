package com.zr.model;
/** 
* @author SkySK: 
* @version 创建时间：2017年9月26日 下午8:03:46 
* 说明 ：
*/
public class User {
     private int uid;//管理员编号
     private String uname;//管理员姓名
     private String upsw;//管理员密码
     private String unum;//管理员序号
     private int rid;//管理员角色
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpsw() {
		return upsw;
	}
	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
     
}
