package com.zr.service;

import java.util.List;

import com.zr.model.Staff;

import net.sf.json.JSONObject;

public interface TeacherService {
	public JSONObject getPapers();
	/**
	 * 查询教师信息
	 * @return 教师对象的集合
	 */
	public List<Staff> selectTeacher();
	/**
	 * 查询教师数据条数
	 * @return 教师数据条数
	 */
	public int selectTeacherCount();
	/**
	 * 删除教师信息
	 * @return 是否成功的标志位
	 */
	public List<Integer> deleteTeacher(List<Integer> eids);
}
