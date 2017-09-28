package com.zr.service;

import com.zr.model.Sub;

import net.sf.json.JSONArray;

public interface SubService {
	/**
	 * 选题申报
	 * @param subname 课题名称
	 * @param subcontent 课题描述
	 * @param subcount 课题容量
	 * @param eid 提交教师ID
	 * @param state 课题状态
	 * @return 是否成功的标志位
	 */
	public int addSub(String subname,String subcontent,int subcount,int eid,int state);
	/**
	 * 根据教师查询选题申报
	 * @param eid 教师ID
	 * @return 选题申报（sub）对象
	 */
	public Sub selectSubByEid(int eid);
  	/**
	 * 根据学生的id，查询学生可选的毕设题目
	 * @param s_id 学生id（用户的id）
	 * @return 选题信息的json数组
	 */
	public JSONArray selectSubBySid(int s_id);
	/**
	 * 学生选择课题
	 * @param s_id 学生id
	 * @param sub_id 选择的课题id
	 * @return 操作结果是否成功
	 */
	public  boolean  addSubToStudent(int s_id, int sub_id);
}
