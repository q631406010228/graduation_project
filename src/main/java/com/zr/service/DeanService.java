package com.zr.service;

import java.util.List;

import com.zr.model.Staff;

public interface DeanService {

	/**
	 * 获得系主任的信息
	 * @return	返回系主任的list
	 */
	public List<Staff> getDean();
	
	/**
	 * 更新系主任的信息
	 * @param ename	系主任的姓名	
	 * @param ecol	学院的外键
	 * @param e_num	系主任的员工号
	 */
	public void updateDean(String ename,int ecol,int e_num,String epsw,int eid);
	
	/**
	 * 添加系主任的信息
	 * @param ename	系主任的姓名	
	 * @param ecol	学院的外键
	 * @param e_num	系主任的员工号
	 */
	public void insertDean(String ename,int ecol,int e_num);
	
	/**
	 * 删除系主任的信息
	 * @param eid	系主任的主键字符串
	 */
	public void deleteDean(String eid);
	
}
