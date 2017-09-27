package com.zr.model;
/**
 * 教职工模型
 * @author Administrator
 *
 */
public class Staff {
	private int eid; //职工id
	private String ename; //职工姓名
	private int ecol; //学院id
	private int replyid; //答辩id
	private int emnum; //教职工号
	private String epsw; //职工密码
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEcol() {
		return ecol;
	}
	public void setEcol(int ecol) {
		this.ecol = ecol;
	}
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public int getEmnum() {
		return emnum;
	}
	public void setEmnum(int emnum) {
		this.emnum = emnum;
	}
	public String getEpsw() {
		return epsw;
	}
	public void setEpsw(String epsw) {
		this.epsw = epsw;
	}	
}
