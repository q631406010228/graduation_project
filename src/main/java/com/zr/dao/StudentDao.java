package com.zr.dao;

import java.util.List;

import com.zr.model.Student;

public interface StudentDao {
	/**
	 * 查询学生根据选题发布者
	 * @param eid 教师id
	 * @return 返回学生对象集合
	 */
	public List<Student> selectStudentByEid(int eid);
	/**
	 * 查询学生名单
	 * @param eid 教师id
	 * @return 学生类型的集合
	 */
	public List<Student> selectStudentFormByEid(int eid);
}
