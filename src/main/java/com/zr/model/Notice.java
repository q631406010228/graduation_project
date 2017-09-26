package com.zr.model;

public class Notice {

	private int sendID;
	private int receiveRoleID;
	private int receiveNum;
	private String title;
	private String content;
	public int getSendID() {
		return sendID;
	}
	public void setSendID(int sendID) {
		this.sendID = sendID;
	}
	public int getReceiveRoleID() {
		return receiveRoleID;
	}
	public void setReceiveRoleID(int receiveRoleID) {
		this.receiveRoleID = receiveRoleID;
	}
	public int getReceiveNum() {
		return receiveNum;
	}
	public void setReceiveNum(int receiveNum) {
		this.receiveNum = receiveNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String data;
	
}
