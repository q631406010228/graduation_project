package com.zr.model;
/**
 * 答辩模型
 * @author Administrator
 *
 */
public class Reply {
	private int replyid; //答辩id
	private String replysite; //答辩地点
	private int subid; //答辩选题
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public String getReplysite() {
		return replysite;
	}
	public void setReplysite(String replysite) {
		this.replysite = replysite;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	
}
