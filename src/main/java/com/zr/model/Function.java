package com.zr.model;
/**
 * 功能模型
 * @author Administrator
 *
 */
public class Function {
	private int funid; //功能ID
	private String funname; //功能名称
	private int funpid; //功能父节点
	private String funurl; //功能请求
	private int state; //功能状态
	private String funcontent; //功能请求结果
	private String funstate;//是否为父节点状态
	public int getFunid() {
		return funid;
	}
	public void setFunid(int funid) {
		this.funid = funid;
	}
	public String getFunname() {
		return funname;
	}
	public void setFunname(String funname) {
		this.funname = funname;
	}
	public int getFunpid() {
		return funpid;
	}
	public void setFunpid(int funpid) {
		this.funpid = funpid;
	}
	public String getFunurl() {
		return funurl;
	}
	public void setFunurl(String funurl) {
		this.funurl = funurl;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getFuncontent() {
		return funcontent;
	}
	public void setFuncontent(String funcontent) {
		this.funcontent = funcontent;
	}
	public String getFunstate() {
		return funstate;
	}
	public void setFunstate(String funstate) {
		this.funstate = funstate;
	}
	
}
