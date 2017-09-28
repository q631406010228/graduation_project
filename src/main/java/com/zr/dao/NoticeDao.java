package com.zr.dao;

import java.util.List;

import com.zr.model.Notice;

public interface NoticeDao {
	
	/**
	 * 教主任保存通知的信息
	 * @param sendID	发通知的角色
	 * @param receiveID	接收通知的角色
	 * @param title		通知的题目	
	 * @param content	通知的内容
	 * @param data		通知的时间
	 */
	public void setDeanNotice(int sendID,int receiveID,String title,String content,String data,int cID);
	
	/**
	 * 教师保存通知的信息
	 * @param sendID	发通知的角色
	 * @param receiveID	接收通知的角色
	 * @param title		通知的题目	
	 * @param content	通知的内容
	 * @param data		通知的时间
	 */
	public void setTeacherNotice(int sendID,int receiveID,String title,String content,String data,int[] num);
	
	/**
	 * 获取指定人的通知
	 * @param num	接收者的号码
	 * @return	返回接收者所有的通知
	 */
	public List<Notice> getNotices(int role,int num,int cID); 
	
}
