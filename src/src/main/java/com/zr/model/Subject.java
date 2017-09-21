package com.zr.model;

public class Subject {
	private  int sub_id;
	private String sub_name;
	private int sub_count;
	private int t_id;
	private  String sub_content;//?选题内容
	private String sub_state;
	private int reply_id;
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getSub_count() {
		return sub_count;
	}
	public void setSub_count(int sub_count) {
		this.sub_count = sub_count;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getSub_content() {
		return sub_content;
	}
	public void setSub_content(String sub_content) {
		this.sub_content = sub_content;
	}
	public String getSub_state() {
		return sub_state;
	}
	public void setSub_state(String sub_state) {
		this.sub_state = sub_state;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

}
