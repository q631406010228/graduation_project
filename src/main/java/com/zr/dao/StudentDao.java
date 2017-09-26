package com.zr.dao;

import java.util.List;

import com.zr.model.Student;

import net.sf.json.JSONObject;

public interface StudentDao {
	/**
	 * 查询学生根据选题发布者
	 * @param eid 教师id
	 * @return 返回学生对象集合
	 */
	public List<Student> selectStudentByEid(int eid);
	
	
	
}
