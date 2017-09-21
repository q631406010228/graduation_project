package com.zr.model;
/**
 * 选题模型
 * @author Administrator
 *
 */
public class Sub {
	private int subid; //选题id
	private String subname; //选题名称
	private String subcount; //选题容量
	private String subcontent; //选题内容
	private int substate; //选题状态
	private int eid;//选题提交者
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSubcount() {
		return subcount;
	}
	public void setSubcount(String subcount) {
		this.subcount = subcount;
	}
	public String getSubcontent() {
		return subcontent;
	}
	public void setSubcontent(String subcontent) {
		this.subcontent = subcontent;
	}
	public int getSubstate() {
		return substate;
	}
	public void setSubstate(int substate) {
		this.substate = substate;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
}
