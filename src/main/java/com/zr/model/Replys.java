package com.zr.model;

import com.sun.star.bridge.oleautomation.Date;

public class Replys {
private int reply_id;
private String reply_site;
private int sub_id;
private String reply_start;
private String reply_end;
public String getReply_start() {
	return reply_start;
}
public void setReply_start(String reply_start) {
	this.reply_start = reply_start;
}
public String getReply_end() {
	return reply_end;
}
public void setReply_end(String reply_end) {
	this.reply_end = reply_end;
}
private int e_id;
private String e_name;
private String sub_name;

public String getSub_name() {
	return sub_name;
}
public void setSub_name(String sub_name) {
	this.sub_name = sub_name;
}
public String getE_name() {
	return e_name;
}
public void setE_name(String e_name) {
	this.e_name = e_name;
}
public int getReply_id() {
	return reply_id;
}
public void setReply_id(int reply_id) {
	this.reply_id = reply_id;
}
public String getReply_site() {
	return reply_site;
}
public void setReply_site(String reply_site) {
	this.reply_site = reply_site;
}
public int getSub_id() {
	return sub_id;
}
public void setSub_id(int sub_id) {
	this.sub_id = sub_id;
}

public int getE_id() {
	return e_id;
}
public void setE_id(int e_id) {
	this.e_id = e_id;
}

}
