package com.zr.model;

public class Function {
	private int fun_id;
	private String fun_name;
	private int fun_father;
	private int r_id;
	private String url;
	
	private String fun_jsp;
	private boolean fun_state;
	public int getFun_id() {
		return fun_id;
	}
	public void setFun_id(int fun_id) {
		this.fun_id = fun_id;
	}
	public String getFun_name() {
		return fun_name;
	}
	public void setFun_name(String fun_name) {
		this.fun_name = fun_name;
	}
	public int getFun_father() {
		return fun_father;
	}
	public void setFun_father(int fun_father) {
		this.fun_father = fun_father;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFun_jsp() {
		return fun_jsp;
	}
	public void setFun_jsp(String fun_jsp) {
		this.fun_jsp = fun_jsp;
	}
	public boolean isFun_state() {
		return fun_state;
	}
	public void setFun_state(boolean fun_state) {
		this.fun_state = fun_state;
	}

}
