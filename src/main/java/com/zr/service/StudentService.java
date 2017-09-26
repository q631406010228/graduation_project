package com.zr.service;

import java.util.List;

import com.zr.model.Student;

public interface StudentService {
	/**
	 * 根据选题发布教师查询学生
	 * @param eid 教师ID
	 * @return 返回学生对象
	 */
	public List<Student> selectStudentByEid(int eid);
	/**
	 * 查询学生名单
	 * @param eid 教师id
	 * @return 学生类型的集合
	 */
	public List<Student> selectStudentFormByEid(int eid);
}
