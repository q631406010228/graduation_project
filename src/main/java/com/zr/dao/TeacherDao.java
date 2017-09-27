package com.zr.dao;

import java.util.List;

import com.zr.model.Staff;

public interface TeacherDao {
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
	public int deleteTeacher(int eid);
	/**
	 * 删除教师角色
	 * @return 是否成功的标志位
	 */
	public int deleteTeacherRole(int eid);
}
