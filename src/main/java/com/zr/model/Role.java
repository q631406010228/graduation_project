package com.zr.model;
/**
 * 角色模型
 * @author Administrator
 *
 */
public class Role {
	private int rid; //角色ID
	private String rname; //角色名称
	private String fids; //角色功能
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getFids() {
		return fids;
	}
	public void setFids(String fids) {
		this.fids = fids;
	}
	
}
