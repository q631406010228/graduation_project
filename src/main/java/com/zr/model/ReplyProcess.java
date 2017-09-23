package com.zr.model;
/**
 * 答辩记录模型
 * @author Administrator
 *
 */
public class ReplyProcess {
	private int prid; //答辩记录id
	private String ques; //答辩记录问题
	private String answer; //答辩记录答案
	private int sid; //学生ID
	private String sname; //学生姓名
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	private String subname; //选题名称
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
