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
	/**
	 * 查询所有学生名单
	 * @return 学生类型的集合
	 */
	public List<Student> selectStudentAll();
	
	/**
	 * 添加学生信息
	 * @param num	学号
	 * @param name	姓名
	 * @param cID	学院
	 * @param mID	专业
	 */
	public void insertStudent(int num,String name,int cID,int mID);
	
	/**
	 * 删除学生信息
	 * @param sID	学生的学号
	 */
	public void deleteStudent(String num);
	
	/**
	 * 修改学生的信息
	 * @param num	新学号
	 * @param name	姓名
	 * @param cID	学院
	 * @param mID	专业
	 * @param preNum	旧学号
	 */
	public void updateStudent(int num, String name, int cID, int mID,int preNum);
}
