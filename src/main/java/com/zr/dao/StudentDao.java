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
	
	/**
	 * 查询学生名单
	 * @param eid 教师id
	 * @return 学生类型的集合
	 */
	public List<Student> selectStudentFormByEid(int eid);
	
	/**
	 * 通过学生的id，设置学生表的选题id
	 * @param sub_id 选题id
	 * @param s_id 学生id
	 * @return 操作的结果
	 */
	public boolean setSubidBySid(int sub_id,int s_id);
	
	/**
	 * 通过选题id 来获取该选题的选择人数
	 * @param su_bid 选题id
	 * @return 人数
	 */
	public Integer getStudentNumberBySubid(int sub_id);
	
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
	public void deleteStudent(int[] num);
	
	/**
	 * 修改学生的信息
	 * @param num	新学号
	 * @param name	姓名
	 * @param cID	学院
	 * @param mID	专业
	 * @param preNum	旧学号
	 */
	public void updateStudent(int num, String name, int cID, int mID,int preNum);
	
	/**
     * 获取学生编号及其密码
     * snum 编号
     * spsw 密码
     */
	Student getStudent(int snum, String spsw);
	/**
	 * 通过学生id，获取学号
	 * @param s_id
	 * @return
	 */
	public String getStudentnumBys_id(int s_id);
}

