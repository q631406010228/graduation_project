package com.zr.model;
/**
 * 毕业进程模型
 * @author Administrator
 *
 */
public class GraduationProcess {
	private int gpid; //进程ID
	private String gpstartime;// 起始时间
	private String gpendtime; //截止时间
	private String gpcontent; //进程名称
	public int getGpid() {
		return gpid;
	}
	public void setGpid(int gpid) {
		this.gpid = gpid;
	}
	public String getGpstartime() {
		return gpstartime;
	}
	public void setGpstartime(String gpstartime) {
		this.gpstartime = gpstartime;
	}
	public String getGpendtime() {
		return gpendtime;
	}
	public void setGpendtime(String gpendtime) {
		this.gpendtime = gpendtime;
	}
	public String getGpcontent() {
		return gpcontent;
	}
	public void setGpcontent(String gpcontent) {
		this.gpcontent = gpcontent;
	}
	
}
