package com.zr.model;

public class Subject {
	private int sub_id; 
	private String sub_name; 
	private int sub_count; 
	private String sub_content; 
	private int sub_state;
	private int e_id;
	private String sub_statecn;
	public String getSub_statecn() {
		return sub_statecn;
	}
	public void setSub_statecn(String sub_statecn) {
		this.sub_statecn = sub_statecn;
	}
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
	public String getSub_content() {
		return sub_content;
	}
	public void setSub_content(String sub_coutent) {
		this.sub_content = sub_coutent;
	}
	public int getSub_state() {
		return sub_state;
	}
	public void setSub_state(int sub_state) {
		this.sub_state = sub_state;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

}
