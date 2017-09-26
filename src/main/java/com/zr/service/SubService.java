package com.zr.service;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface SubService {
	/**
	 * 添加选题信息
	 * @param subname
	 * @param subcontent
	 * @param subcount
	 * @param eid
	 * @param state
	 * @return
	 */
	public int addSub(String subname,String subcontent,int subcount,int eid,int state);
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
